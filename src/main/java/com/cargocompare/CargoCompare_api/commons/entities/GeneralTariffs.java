package com.cargocompare.CargoCompare_api.commons.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarifas_generales")
public class GeneralTariffs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer parameter;
    private double price;

    @OneToOne
    @JoinColumn(name = "tipo_tarifa_id", nullable = false)
    private TariffTypes tariffType;

    @OneToMany(mappedBy = "generalTariffs")
    private List<TariffConditions> tariffConditions;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Supplier supplier;
}
