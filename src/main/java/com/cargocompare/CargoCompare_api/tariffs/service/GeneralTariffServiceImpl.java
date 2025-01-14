package com.cargocompare.CargoCompare_api.tariffs.service;

import com.cargocompare.CargoCompare_api.tariffs.GeneralTariff;
import com.cargocompare.CargoCompare_api.tariffs.GeneralTariffRepository;
import org.springframework.stereotype.Service;

@Service
public class GeneralTariffServiceImpl implements GeneralTariffService {

    private final GeneralTariffRepository generalTariffRepository;

    public GeneralTariffServiceImpl(GeneralTariffRepository generalTariffRepository) {
        this.generalTariffRepository = generalTariffRepository;
    }


    @Override
    public GeneralTariff createTariff(GeneralTariff tariff) {
        return null;
    }
}
