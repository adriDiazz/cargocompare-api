package com.cargocompare.CargoCompare_api.tariffs.service;

import com.cargocompare.CargoCompare_api.tariffs.dto.CreateTariffRequest;
import com.cargocompare.CargoCompare_api.tariffs.dto.GeneralTariffDTO;

public interface GeneralTariffService {

    GeneralTariffDTO createTariff(CreateTariffRequest tariff);
}
