package com.cargocompare.CargoCompare_api.companies;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CreateCompanyRequest;
import com.cargocompare.CargoCompare_api.companies.service.CompaniesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/companies")
public class CompaniesController {

    private final CompaniesService companiesService;

    public CompaniesController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<LogisticCompany> createCompany(
            @RequestBody @Valid CreateCompanyRequest companyRequest
    ) {
        return ResponseEntity.ok(companiesService.createCompany(companyRequest));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<CompanyDTO>> getCompanies() {
        return ResponseEntity.ok(companiesService.getCompanies());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(
            @PathVariable Long companyId
    ) {
        return ResponseEntity.ok(companiesService.getCompanyById(companyId));
    }
}
