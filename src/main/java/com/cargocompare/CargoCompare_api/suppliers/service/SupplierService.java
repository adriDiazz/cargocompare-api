package com.cargocompare.CargoCompare_api.suppliers.service;

import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.suppliers.dto.CreateSupplierRequest;

public interface SupplierService {
    Supplier createSupplier(CreateSupplierRequest supplierRequest);
    Supplier createSupplierForCompany(CreateSupplierRequest supplierRequest, Long companyId, Long tariffId);
}
