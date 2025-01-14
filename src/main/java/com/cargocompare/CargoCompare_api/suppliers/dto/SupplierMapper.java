package com.cargocompare.CargoCompare_api.suppliers.dto;

import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.tariffs.dto.TariffMapper;

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

    public static SupplierDTO toSupplierDTO(Supplier supplier) {
        return SupplierDTO.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())
                .cif(supplier.getCif())
                .city(supplier.getCity())
                .country(supplier.getCountry())
                .description(supplier.getDescription())
                .contactEmail(supplier.getContactEmail())
                .contactPerson(supplier.getContactPerson())
                .contactPhone(supplier.getContactPhone())
                .logo(supplier.getLogo())
                .postalCode(supplier.getPostalCode())
                .province(supplier.getProvince())
                .socialReason(supplier.getSocialReason())
                .webSite(supplier.getWebSite())
                .build();
    }
}
