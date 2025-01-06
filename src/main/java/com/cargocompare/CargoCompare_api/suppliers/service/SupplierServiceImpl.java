package com.cargocompare.CargoCompare_api.suppliers.service;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import com.cargocompare.CargoCompare_api.companies.CompaniesRepository;
import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.supplierCompany.SupplierCompanyRepository;
import com.cargocompare.CargoCompare_api.suppliers.SuppliersRepository;
import com.cargocompare.CargoCompare_api.suppliers.dto.CreateSupplierRequest;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierMapper;
import com.cargocompare.CargoCompare_api.suppliers.exceptions.CreatingSupplierError;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SuppliersRepository suppliersRepository;
    private final SupplierCompanyRepository supplierCompanyRepository;
    private final CompaniesRepository companiesRepository;

    public SupplierServiceImpl(SuppliersRepository suppliersRepository, SupplierCompanyRepository supplierCompanyRepository, CompaniesRepository companiesRepository) {
        this.suppliersRepository = suppliersRepository;
        this.supplierCompanyRepository = supplierCompanyRepository;
        this.companiesRepository = companiesRepository;
    }


    @Override
    public Supplier createSupplier(CreateSupplierRequest supplierRequest) {
        return Optional.of(supplierRequest)
                .map(SupplierMapper::toSupplier)
                .map(suppliersRepository::save)
                .orElseThrow(() -> new CreatingSupplierError("Error al crear el proveedor"));
    }

    @Override
    public Supplier createSupplierForCompany(CreateSupplierRequest supplierRequest, Long companyId, Long tariffId) {

        Supplier supplier = SupplierMapper.toSupplier(supplierRequest);

        supplier = suppliersRepository.save(supplier);

        LogisticCompany logisticCompany = companiesRepository.findById(companyId)
                .orElseThrow(() -> new CreatingSupplierError("La compañía con ID " + companyId + " no fue encontrada"));

        SupplierCompany relation = SupplierCompany.builder()
                .logisticCompany(logisticCompany)
                .supplier(supplier)
                .tariffId(tariffId)
                .build();

        supplierCompanyRepository.save(relation);

        return supplier;
    }

}
