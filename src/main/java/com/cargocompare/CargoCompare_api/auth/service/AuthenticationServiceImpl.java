package com.cargocompare.CargoCompare_api.auth.service;

import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationRequest;
import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationResponse;
import com.cargocompare.CargoCompare_api.auth.dto.UserRegisterRequest;
import com.cargocompare.CargoCompare_api.commons.config.JwtService;
import com.cargocompare.CargoCompare_api.notifications.GmailNotificationService;
import com.cargocompare.CargoCompare_api.user.User;
import com.cargocompare.CargoCompare_api.user.Role;
import com.cargocompare.CargoCompare_api.user.UserRepository;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AdminVerificationService adminVerificationService;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, AdminVerificationService adminVerificationService, GmailNotificationService gmailNotificationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.adminVerificationService = adminVerificationService;
    }


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );

        var isUserAdmin = user.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        if(isUserAdmin) {
            String verificationCode = adminVerificationService.generateVerificationCode(user.getEmail());

            adminVerificationService.sendVerificationCode(user.getEmail(), verificationCode);

            adminVerificationService.saveCode(user.getEmail(), verificationCode);

            return AuthenticationResponse.builder()
                    .verificationCode(verificationCode)
                    .build();
        } else {
            return proceedWithNormalAuthentication(user);
        }


    }

    private AuthenticationResponse proceedWithNormalAuthentication(User user) {
        var userDTO = UserDTO.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .isVerified(user.isVerified())
                .authorities(user.getAuthorities())
                .logisticCompany(user.getLogisticCompany())
                .supplier(user.getSupplier())
                .build();

        Map<String, Object> extraClaims = Map.of("user", userDTO);

        var jwtToken = jwtService.generateToken(extraClaims, user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse proceedWithFullAuthentication(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var userDTO = UserDTO.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .isVerified(user.isVerified())
                .authorities(user.getAuthorities())
                .logisticCompany(user.getLogisticCompany())
                .supplier(user.getSupplier())
                .build();

        Map<String, Object> extraClaims = Map.of("user", userDTO);

        var jwtToken = jwtService.generateToken(extraClaims, user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }


    @Override
    public AuthenticationResponse register(UserRegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .lastName(request.getLastName())
                .role(request.getRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .isEnabled(true) // Activar la cuenta por defecto
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isVerified(false) // Verificación pendiente
                .mfaEnabled(false) // MFA desactivado por defecto
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(jwtService.generateRefreshToken(user))
                .build();
    }



}
