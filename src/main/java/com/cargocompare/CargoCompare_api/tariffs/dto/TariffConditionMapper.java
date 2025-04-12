package com.cargocompare.CargoCompare_api.tariffs.dto;

import com.cargocompare.CargoCompare_api.commons.entities.TariffConditions;

public class TariffConditionMapper {

    public static TariffConditionRequest toDTO(TariffConditions tariffCondition) {
        TariffConditionRequest conditionDTO = new TariffConditionRequest();
        conditionDTO.setType(tariffCondition.getType());
        conditionDTO.setFactor(tariffCondition.getFactor());
        return conditionDTO;
    }

    public static TariffConditions toEntity(TariffConditionRequest tariffConditionDTO) {
        TariffConditions condition = new TariffConditions();
        condition.setType(tariffConditionDTO.getType());
        condition.setFactor(tariffConditionDTO.getFactor());
        return condition;
    }
}
