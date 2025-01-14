package com.cargocompare.CargoCompare_api.companies.dto;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;

public class CompanyMapper {
    public static LogisticCompany toLogisticCompany(CreateCompanyRequest companyRequest) {
        return LogisticCompany.builder()
                .name(companyRequest.getName())
                .address(companyRequest.getAddress())
                .phone(companyRequest.getPhone())
                .email(companyRequest.getEmail())
                .cif(companyRequest.getCif())
                .city(companyRequest.getCity())
                .country(companyRequest.getCountry())
                .description(companyRequest.getDescription())
                .contactEmail(companyRequest.getContactEmail())
                .contactPerson(companyRequest.getContactPerson())
                .contactPhone(companyRequest.getContactPhone())
                .logo(companyRequest.getLogo())
                .postalCode(companyRequest.getPostalCode())
                .province(companyRequest.getProvince())
                .socialReason(companyRequest.getSocialReason())
                .webSite(companyRequest.getWebSite())
                .build();
    }

    public static CompanyDTO toCompanyDTO(LogisticCompany logisticCompany) {
        return CompanyDTO.builder()
                .id(logisticCompany.getId())
                .name(logisticCompany.getName())
                .address(logisticCompany.getAddress())
                .phone(logisticCompany.getPhone())
                .email(logisticCompany.getEmail())
                .cif(logisticCompany.getCif())
                .city(logisticCompany.getCity())
                .country(logisticCompany.getCountry())
                .description(logisticCompany.getDescription())
                .contactEmail(logisticCompany.getContactEmail())
                .contactPerson(logisticCompany.getContactPerson())
                .contactPhone(logisticCompany.getContactPhone())
                .logo(logisticCompany.getLogo())
                .postalCode(logisticCompany.getPostalCode())
                .province(logisticCompany.getProvince())
                .socialReason(logisticCompany.getSocialReason())
                .webSite(logisticCompany.getWebSite())
                .build();
    }
}
