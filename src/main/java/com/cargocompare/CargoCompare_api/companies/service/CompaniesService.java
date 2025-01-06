package com.cargocompare.CargoCompare_api.companies.service;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CreateCompanyRequest;

public interface CompaniesService {
    LogisticCompany createCompany(CreateCompanyRequest companyRequest);
}
