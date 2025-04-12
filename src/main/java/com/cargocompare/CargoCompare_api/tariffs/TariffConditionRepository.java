package com.cargocompare.CargoCompare_api.tariffs;

import com.cargocompare.CargoCompare_api.commons.entities.TariffConditions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffConditionRepository extends JpaRepository<TariffConditions, Long> {
    // Custom query methods can be defined here if needed
}
