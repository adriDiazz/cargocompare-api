package com.cargocompare.CargoCompare_api.commons.entities;

import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "zonas_proveedor")
public class SupplierZones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provincia_id", nullable = false)
    private Province province;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Supplier supplier;

    @Column(name = "zona", nullable = false)
    private Integer zone;

}
