package com.cargocompare.CargoCompare_api.supplierCompany.service;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import com.cargocompare.CargoCompare_api.companies.CompaniesRepository;
import com.cargocompare.CargoCompare_api.companies.exceptions.CreatingCompanyError;
import com.cargocompare.CargoCompare_api.supplierCompany.SupplierCompanyRepository;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.CreateSupplierCompanyResquest;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.SupplierCompanyMapper;
import com.cargocompare.CargoCompare_api.suppliers.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierCompanyServiceImpl implements SupplierCompanyService{

    private final SupplierCompanyRepository supplierCompanyRepository;
    private final SuppliersRepository suppliersRepository;
    private final CompaniesRepository companiesRepository;

    public SupplierCompanyServiceImpl(SupplierCompanyRepository supplierCompanyRepository, SuppliersRepository suppliersRepository, CompaniesRepository companiesRepository) {
        this.supplierCompanyRepository = supplierCompanyRepository;
        this.suppliersRepository = suppliersRepository;
        this.companiesRepository = companiesRepository;
    }

    @Override
    public SupplierCompany createSupplierCompany(CreateSupplierCompanyResquest supplierCompany) {
        return Optional.of(supplierCompany)
                .map(SupplierCompanyMapper::toEntity)
                .map(supplierCompanyEntity -> {
                    var supplier = suppliersRepository.findById(supplierCompany.getSupplier())
                            .orElseThrow(() -> new CreatingCompanyError("El proveedor no existe"));
                    var company = companiesRepository.findById(supplierCompany.getLogisticCompany())
                            .orElseThrow(() -> new CreatingCompanyError("La compañía no existe"));
                    supplierCompanyEntity.setSupplier(supplier);
                    supplierCompanyEntity.setLogisticCompany(company);

                    return supplierCompanyEntity;
                })
                .map(supplierCompanyRepository::save)
                .orElseThrow(() -> new CreatingCompanyError("Error al crear la compañía"));
    }
}
