package com.cargocompare.CargoCompare_api.tariffs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TariffConditionRequest {
    private String type;
    private double factor;
}

