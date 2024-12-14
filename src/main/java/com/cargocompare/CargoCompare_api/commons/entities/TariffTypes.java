package com.cargocompare.CargoCompare_api.commons.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_tarifa")
public class TariffTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToOne(mappedBy = "tariffType")
    private GeneralTariffs generalTariffs;
}
