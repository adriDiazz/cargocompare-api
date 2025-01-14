package com.cargocompare.CargoCompare_api.suppliers;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import com.cargocompare.CargoCompare_api.tariffs.GeneralTariff;
import com.cargocompare.CargoCompare_api.commons.entities.SupplierZones;
import com.cargocompare.CargoCompare_api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "proveedores")
public class Supplier {

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

    @OneToMany(mappedBy = "supplier")
    private List<GeneralTariff> generalTariffs = new ArrayList<>();

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierCompany> companySuppliers = new ArrayList<>();

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierZones> supplierZones = new ArrayList<>();

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> employees;

}
