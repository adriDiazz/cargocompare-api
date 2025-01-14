package com.cargocompare.CargoCompare_api.supplierCompany.dto;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierCompanyDTO {

    private Long id;
    private Long logisticCompany;
    private SupplierDTO supplier;
    private Long tariffId;


}

