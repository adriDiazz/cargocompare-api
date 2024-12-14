package com.cargocompare.CargoCompare_api.commons.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresas_logisticas")
public class LogisticCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "logisticCompany")
    private List<User> employees;

    @OneToMany(mappedBy = "logisticCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LogisticCompanySupplier> companySuppliers = new ArrayList<>();
}
