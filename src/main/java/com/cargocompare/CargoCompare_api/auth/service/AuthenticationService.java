package com.cargocompare.CargoCompare_api.auth.service;

import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationRequest;
import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}

