package com.cargocompare.CargoCompare_api.tariffs.dto;

import com.cargocompare.CargoCompare_api.tariffs.GeneralTariff;

public class TariffMapper {

    public static GeneralTariffDTO toDTO(GeneralTariff tariff) {
        GeneralTariffDTO tariffDTO = new GeneralTariffDTO();
        tariffDTO.setParameter(tariff.getParameter());
        tariffDTO.setTariffType(tariff.getTariffType());
        tariffDTO.setPrice(tariff.getPrice());
        tariffDTO.setId(tariff.getId());
        tariffDTO.setSupplierId(tariff.getSupplier().getId());
        return tariffDTO;
    }

    public static GeneralTariff toEntity(CreateTariffRequest tariffDTO) {
        GeneralTariff tariff = new GeneralTariff();
        tariff.setParameter(tariffDTO.getParameter());
        tariff.setTariffType(tariffDTO.getTariffType());
        tariff.setPrice(tariffDTO.getPrice());
        return tariff;
    }
}
