package com.cargocompare.CargoCompare_api.commons.entities;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "empresas_logistica_proveedor")
public class SupplierCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresas_logistica_id", nullable = false)
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Supplier supplier;

    @Column(name = "tarifa_id", nullable = true)
    private Long tariffId;

}