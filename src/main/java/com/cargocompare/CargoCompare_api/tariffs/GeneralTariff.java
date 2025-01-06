package com.cargocompare.CargoCompare_api.tariffs;

import com.cargocompare.CargoCompare_api.commons.entities.TariffConditions;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
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
public class GeneralTariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer parameter;
    private double price;

    @Enumerated(EnumType.STRING) // Guardará los valores como texto en la base de datos
    @Column(name = "tipo_tarifa", nullable = false)
    private TariffType tariffType;

    @OneToMany(mappedBy = "generalTariffs")
    private List<TariffConditions> tariffConditions;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Supplier supplier;
}
