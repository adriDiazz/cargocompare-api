package com.cargocompare.CargoCompare_api.supplierCompany.service;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.CreateSupplierCompanyResquest;
public interface SupplierCompanyService {
    SupplierCompany createSupplierCompany(CreateSupplierCompanyResquest supplierCompany);
}
