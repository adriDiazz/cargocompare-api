package com.cargocompare.CargoCompare_api.tariffs.dto;

import com.cargocompare.CargoCompare_api.tariffs.GeneralTariff;

public class TariffMapper {

    public static GeneralTariffDTO toDTO(GeneralTariff tariff) {
        GeneralTariffDTO tariffDTO = new GeneralTariffDTO();
        tariffDTO.setParameter(tariff.getParameter());
        tariffDTO.setTariffType(tariff.getTariffType().name());
        tariffDTO.setPrice(tariff.getPrice());
        return tariffDTO;
    }
}
