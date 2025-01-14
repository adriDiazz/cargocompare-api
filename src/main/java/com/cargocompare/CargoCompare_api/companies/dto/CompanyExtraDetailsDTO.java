package com.cargocompare.CargoCompare_api.companies.dto;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.SupplierCompanyDTO;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyExtraDetailsDTO extends CompanyDTO {
    private List<UserDTO> employees;
    private List<SupplierCompanyDTO> companySuppliers;

    public CompanyExtraDetailsDTO(Long id, String name, String address, String phone, String email, String contactPerson, String contactPhone, String contactEmail, String webSite, String logo, String cif, String socialReason, String description, String postalCode, String city, String province, String country, List<UserDTO> employees, List<SupplierCompanyDTO> companySuppliers) {
        super(id, name, address, phone, email, contactPerson, contactPhone, contactEmail, webSite, logo, cif, socialReason, description, postalCode, city, province, country);
        this.employees = employees;
        this.companySuppliers = companySuppliers;
    }

    public CompanyExtraDetailsDTO(LogisticCompany company, List<SupplierCompanyDTO> supplierCompanyDTO, List<UserDTO> employees) {
        super(company.getId(), company.getName(), company.getAddress(), company.getPhone(), company.getEmail(), company.getContactPerson(), company.getContactPhone(), company.getContactEmail(), company.getWebSite(), company.getLogo(), company.getCif(), company.getSocialReason(), company.getDescription(), company.getPostalCode(), company.getCity(), company.getProvince(), company.getCountry());
        this.employees = employees;
        this.companySuppliers = supplierCompanyDTO;
    }
}
