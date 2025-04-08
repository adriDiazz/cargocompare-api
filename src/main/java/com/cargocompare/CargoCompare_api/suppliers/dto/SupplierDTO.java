package com.cargocompare.CargoCompare_api.suppliers.dto;


import com.cargocompare.CargoCompare_api.tariffs.dto.GeneralTariffDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class SupplierDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    private String webSite;
    private String logo;
    private String cif;
    private String socialReason;
    private String description;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    private List<GeneralTariffDTO> generalTariffs;
}