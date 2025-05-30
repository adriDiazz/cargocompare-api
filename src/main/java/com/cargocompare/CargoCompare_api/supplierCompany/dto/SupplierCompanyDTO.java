package com.cargocompare.CargoCompare_api.supplierCompany.dto;

import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SupplierCompanyDTO {

    private Long id;
    private Long logisticCompany;
    private SupplierDTO supplier;
    private Long tariffId;


}

