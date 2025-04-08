package com.cargocompare.CargoCompare_api.suppliers.service;

import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.suppliers.dto.CreateSupplierRequest;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    Supplier createSupplier(CreateSupplierRequest supplierRequest);
    Supplier createSupplierForCompany(CreateSupplierRequest supplierRequest, Long companyId);
    List<SupplierDTO> getSuppliers();
    SupplierDTO getSupplierById(Long id);
    SupplierDTO getSupplierByCompanyIdAndSupplierId(Long companyId, Long supplierId);
}
