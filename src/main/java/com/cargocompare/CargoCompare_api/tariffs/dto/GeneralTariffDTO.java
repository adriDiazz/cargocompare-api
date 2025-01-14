package com.cargocompare.CargoCompare_api.tariffs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralTariffDTO {

    private Long id;
    private Integer parameter;
    private double price;
    private String tariffType;  // Representa el tipo de tarifa como una cadena
    private Long supplierId;    // Solo almacenamos el ID del proveedor para referencias simples

    // Lista de condiciones de tarifa, representadas por sus DTOs

    // Constructor u otro método para facilitar la conversión de la entidad a DTO

}