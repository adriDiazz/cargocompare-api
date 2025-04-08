package com.cargocompare.CargoCompare_api.supplierCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierCompanyResquest {
    private Long id;
    private Long logisticCompany;
    private Long supplier;
    private Long tariffId;
}
