package com.cargocompare.CargoCompare_api.tariffs;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.tariffs.service.GeneralTariffService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/tariffs")
public class GeneralTariffController {

    private final GeneralTariffService generalTariffService;

    public GeneralTariffController(GeneralTariffService generalTariffService) {
        this.generalTariffService = generalTariffService;
    }

    @PostMapping("/supplier/{supplierId}/company/{companyId}")
    public void createGeneralTariff() {

    }
}
