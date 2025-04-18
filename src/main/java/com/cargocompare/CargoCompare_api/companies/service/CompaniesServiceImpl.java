package com.cargocompare.CargoCompare_api.companies.service;

import com.cargocompare.CargoCompare_api.companies.CompaniesRepository;
import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyExtraDetailsDTO;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyMapper;
import com.cargocompare.CargoCompare_api.companies.dto.CreateCompanyRequest;
import com.cargocompare.CargoCompare_api.companies.exceptions.CompanyNotFoundError;
import com.cargocompare.CargoCompare_api.companies.exceptions.CreatingCompanyError;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.SupplierCompanyDTO;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.SupplierCompanyMapper;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import com.cargocompare.CargoCompare_api.user.dto.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<CompanyDTO> getCompanies() {
        return companiesRepository.findAll().stream()
                .map(CompanyMapper::toCompanyDTO)
                .toList();
    }

    @Override
    public CompanyExtraDetailsDTO getCompanyById(Long id) {
        var company = companiesRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundError("La compañía con ID " + id + " no fue encontrada"));

        List<SupplierCompanyDTO> supplierCompanyDTO = company.getCompanySuppliers().stream()
                .map(SupplierCompanyMapper::toDTO)
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(dto -> dto.getSupplier().getId(), dto -> dto, (dto1, dto2) -> dto1),
                        map -> new ArrayList<>(map.values())
                ));

        List<UserDTO> employees = company.getEmployees().stream()
                .map(UserMapper::toDTO).toList();

        return new CompanyExtraDetailsDTO(
                company,
                supplierCompanyDTO,
                employees
        );
    }

    @Override
    public void deleteCompany(Long id) {
        var company = companiesRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundError("La compañía con ID " + id + " no fue encontrada"));

        companiesRepository.delete(company);
    }

    @Override
    public CompanyDTO updateCompany(Long id, CreateCompanyRequest companyRequest) {
        return companiesRepository.findById(id)
                .map(company -> {
                    company.setName(companyRequest.getName());
                    company.setAddress(companyRequest.getAddress());
                    company.setPhone(companyRequest.getPhone());
                    company.setEmail(companyRequest.getEmail());
                    company.setCif(companyRequest.getCif());
                    company.setCity(companyRequest.getCity());
                    company.setCountry(companyRequest.getCountry());
                    company.setDescription(companyRequest.getDescription());
                    company.setContactEmail(companyRequest.getContactEmail());
                    company.setContactPerson(companyRequest.getContactPerson());
                    company.setContactPhone(companyRequest.getContactPhone());
                    company.setLogo(companyRequest.getLogo());
                    company.setPostalCode(companyRequest.getPostalCode());
                    company.setProvince(companyRequest.getProvince());
                    company.setSocialReason(companyRequest.getSocialReason());
                    company.setWebSite(companyRequest.getWebSite());
                    return companiesRepository.save(company);
                })
                .map(CompanyMapper::toCompanyDTO)
                .orElseThrow(() -> new CompanyNotFoundError("La compañía con ID " + id + " no fue encontrada"));
    }


}
