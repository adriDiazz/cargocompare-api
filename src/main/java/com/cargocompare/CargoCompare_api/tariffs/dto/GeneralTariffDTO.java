package com.cargocompare.CargoCompare_api.tariffs.dto;

import com.cargocompare.CargoCompare_api.tariffs.TariffType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralTariffDTO {

    private Long id;
    private String parameter;
    private double price;
    private TariffType tariffType;
    private Long supplierId;
    private List<TariffConditionRequest> conditions;



}