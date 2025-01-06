package com.cargocompare.CargoCompare_api.companies.service;

import com.cargocompare.CargoCompare_api.companies.CompaniesRepository;
import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyMapper;
import com.cargocompare.CargoCompare_api.companies.dto.CreateCompanyRequest;
import com.cargocompare.CargoCompare_api.companies.exceptions.CreatingCompanyError;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompaniesServiceImpl implements CompaniesService{

    private final CompaniesRepository companiesRepository;

    public CompaniesServiceImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }


    @Override
    public LogisticCompany createCompany(CreateCompanyRequest companyRequest) {
        return Optional.of(companyRequest)
                .map(CompanyMapper::toLogisticCompany)
                .map(companiesRepository::save)
                .orElseThrow(() -> new CreatingCompanyError("Error al crear la compañía"));
    }


}
