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
public class CreateTariffRequest {
    private String parameter;
    private double price;
    private TariffType tariffType;  // Representa el tipo de tarifa como una cadena
    private Long supplierId;
    private Long logisticCompanyId; // ID de la empresa logística asociada a la tarifa
    private List<TariffConditionRequest> conditions;

}
