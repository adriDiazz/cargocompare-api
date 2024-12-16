package com.cargocompare.CargoCompare_api.commons.constants;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorApiResponse {
    private String message;
    private int status;

}
