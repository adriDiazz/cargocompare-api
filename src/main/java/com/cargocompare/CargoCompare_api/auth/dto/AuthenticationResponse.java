package com.cargocompare.CargoCompare_api.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationResponse {

    private String accessToken;
    private String refreshToken;
    private boolean mfaEnabled;
    private String secretImageUri;
    private String verificationCode;
}
