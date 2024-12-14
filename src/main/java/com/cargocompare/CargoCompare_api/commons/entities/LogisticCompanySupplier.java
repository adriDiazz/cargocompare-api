package com.cargocompare.CargoCompare_api.commons.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresas_logistica_proveedor")
public class LogisticCompanySupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresas_logistica_id", nullable = false)
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Supplier supplier;

    @Column(name = "tarifa_id", nullable = false)
    private Long tariffId;

}