package com.cargocompare.CargoCompare_api.auth;

import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationRequest;
import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationResponse;
import com.cargocompare.CargoCompare_api.auth.dto.UserRegisterRequest;
import com.cargocompare.CargoCompare_api.auth.dto.VerificationCodeRequest;
import com.cargocompare.CargoCompare_api.auth.service.AdminVerificationService;
import com.cargocompare.CargoCompare_api.auth.service.AuthenticationService;
import com.cargocompare.CargoCompare_api.commons.config.JwtService;
import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.user.User;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import com.cargocompare.CargoCompare_api.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final UserService userService;
    private final AdminVerificationService verificationService;

    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService, UserService userService, AdminVerificationService verificationService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.userService = userService;
        this.verificationService = verificationService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(HttpServletRequest request) {

        String token = jwtService.getTokenFromCookies(request);

        if (token == null || !jwtService.isTokenValidSign(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String email = jwtService.extractUsername(token);
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAuthorities());
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody @Valid UserRegisterRequest authenticationRequest
    ) {
        return ResponseEntity.ok(authenticationService.register(authenticationRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest authenticationRequest,
            HttpServletResponse response
    ) {
        var auth = authenticationService.authenticate(authenticationRequest);

        if(auth.getVerificationCode() == null) {
            // Configurar cookies seguras
            Cookie tokenCookie = new Cookie("token", auth.getAccessToken());
            tokenCookie.setHttpOnly(true);
//        tokenCookie.setSecure(true); // Solo HTTPS
            tokenCookie.setPath("/");
            tokenCookie.setMaxAge(24 * 60 * 60); // Token expira en 24 horas

            Cookie refreshCookie = new Cookie("refreshToken", auth.getRefreshToken());
            refreshCookie.setHttpOnly(true);
//        refreshCookie.setSecure(true); // Solo HTTPS
            refreshCookie.setPath("/");
            refreshCookie.setMaxAge(7 * 24 * 60 * 60); // Refresh token expira en 7 días

            response.addCookie(tokenCookie);
            response.addCookie(refreshCookie);
        }

        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .accessToken(auth.getAccessToken())
                        .refreshToken(auth.getRefreshToken())
                        .build()
        );
    }

    @PostMapping("/verify-admin-code")
    public ResponseEntity<?> verifyCode(@RequestBody @Valid VerificationCodeRequest codeRequest, HttpServletResponse response) {
        boolean isValid = verificationService.verifyCode(codeRequest.getEmail(), codeRequest.getCode());
        if (isValid) {
            var auth = authenticationService.proceedWithFullAuthentication(codeRequest.getEmail());
            // Configurar cookies seguras
            Cookie tokenCookie = new Cookie("token", auth.getAccessToken());
            tokenCookie.setHttpOnly(true);
//        tokenCookie.setSecure(true); // Solo HTTPS
            tokenCookie.setPath("/");
            tokenCookie.setMaxAge(24 * 60 * 60); // Token expira en 24 horas

            Cookie refreshCookie = new Cookie("refreshToken", auth.getRefreshToken());
            refreshCookie.setHttpOnly(true);
//        refreshCookie.setSecure(true); // Solo HTTPS
            refreshCookie.setPath("/");
            refreshCookie.setMaxAge(7 * 24 * 60 * 60); // Refresh token expira en 7 días

            response.addCookie(tokenCookie);
            response.addCookie(refreshCookie);
            return ResponseEntity.ok(
                    AuthenticationResponse.builder()
                            .accessToken(auth.getAccessToken())
                            .refreshToken(auth.getRefreshToken())
                            .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired verification code");
        }
    }
}
