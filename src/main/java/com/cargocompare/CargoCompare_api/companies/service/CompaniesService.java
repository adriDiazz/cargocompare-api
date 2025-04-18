package com.cargocompare.CargoCompare_api.companies.service;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyExtraDetailsDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CreateCompanyRequest;

import java.util.List;
import java.util.Optional;

public interface CompaniesService {
    LogisticCompany createCompany(CreateCompanyRequest companyRequest);
    List<CompanyDTO> getCompanies();
    CompanyExtraDetailsDTO getCompanyById(Long id);
    void deleteCompany(Long id);
    CompanyDTO updateCompany(Long id, CreateCompanyRequest companyRequest);
}
