package com.cargocompare.CargoCompare_api.suppliers.dto;

import com.cargocompare.CargoCompare_api.suppliers.Supplier;

public class SupplierMapper {

    public static Supplier toSupplier(CreateSupplierRequest createSupplierRequest) {
        return Supplier.builder()
                .name(createSupplierRequest.getName())
                .address(createSupplierRequest.getAddress())
                .phone(createSupplierRequest.getPhone())
                .email(createSupplierRequest.getEmail())
                .cif(createSupplierRequest.getCif())
                .city(createSupplierRequest.getCity())
                .country(createSupplierRequest.getCountry())
                .description(createSupplierRequest.getDescription())
                .contactEmail(createSupplierRequest.getContactEmail())
                .contactPerson(createSupplierRequest.getContactPerson())
                .contactPhone(createSupplierRequest.getContactPhone())
                .logo(createSupplierRequest.getLogo())
                .postalCode(createSupplierRequest.getPostalCode())
                .province(createSupplierRequest.getProvince())
                .socialReason(createSupplierRequest.getSocialReason())
                .webSite(createSupplierRequest.getWebSite())
                .build();
    }
}
