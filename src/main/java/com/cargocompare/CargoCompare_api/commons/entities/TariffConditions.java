package com.cargocompare.CargoCompare_api.commons.entities;

import com.cargocompare.CargoCompare_api.tariffs.GeneralTariff;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "condiciones_tarifa")
public class TariffConditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double factor;

    @ManyToOne
    @JoinColumn(name = "tarifa_id", nullable = false)
    private GeneralTariff generalTariffs;
}
