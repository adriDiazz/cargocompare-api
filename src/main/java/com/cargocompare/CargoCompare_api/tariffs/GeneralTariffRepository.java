package com.cargocompare.CargoCompare_api.tariffs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralTariffRepository extends JpaRepository<GeneralTariffs, Long> {
}
