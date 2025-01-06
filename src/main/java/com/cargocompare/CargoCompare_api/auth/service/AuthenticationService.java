package com.cargocompare.CargoCompare_api.auth.service;

import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationRequest;
import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationResponse;
import com.cargocompare.CargoCompare_api.auth.dto.UserRegisterRequest;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    AuthenticationResponse proceedWithFullAuthentication(String email);
    AuthenticationResponse register(UserRegisterRequest request);
}

