package com.cargocompare.CargoCompare_api.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {
    @NotNull
    @Email
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters long", max = 100)
    private String password;

}