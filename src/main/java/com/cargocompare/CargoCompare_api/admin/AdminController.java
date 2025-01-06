package com.cargocompare.CargoCompare_api.admin;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.companies.dto.CreateCompanyRequest;
import com.cargocompare.CargoCompare_api.companies.service.CompaniesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final CompaniesService companiesService;

    public AdminController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @PostMapping("/companies")
    public ResponseEntity<LogisticCompany> createCompany(
            @RequestBody CreateCompanyRequest companyRequest
    ) {
        return ResponseEntity.ok(companiesService.createCompany(companyRequest));
    }
}
