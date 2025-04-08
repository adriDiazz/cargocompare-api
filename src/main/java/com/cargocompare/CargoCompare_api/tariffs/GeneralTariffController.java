package com.cargocompare.CargoCompare_api.tariffs;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.tariffs.dto.CreateTariffRequest;
import com.cargocompare.CargoCompare_api.tariffs.dto.GeneralTariffDTO;
import com.cargocompare.CargoCompare_api.tariffs.service.GeneralTariffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/tariffs")
public class GeneralTariffController {

    private final GeneralTariffService generalTariffService;

    public GeneralTariffController(GeneralTariffService generalTariffService) {
        this.generalTariffService = generalTariffService;
    }

    @PostMapping("/")
    public ResponseEntity<GeneralTariffDTO> createGeneralTariff(@RequestBody CreateTariffRequest tariff) {
        return ResponseEntity.ok(generalTariffService.createTariff(tariff));
    }
}
