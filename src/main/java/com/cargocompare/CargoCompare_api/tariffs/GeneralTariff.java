package com.cargocompare.CargoCompare_api.tariffs;

import com.cargocompare.CargoCompare_api.commons.entities.TariffConditions;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarifas_generales")
public class GeneralTariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parameter;
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
