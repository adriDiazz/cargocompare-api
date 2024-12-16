package com.cargocompare.CargoCompare_api.auth;

import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationRequest;
import com.cargocompare.CargoCompare_api.auth.dto.AuthenticationResponse;
import com.cargocompare.CargoCompare_api.auth.service.AuthenticationService;
import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
