package com.cargocompare.CargoCompare_api.tariffs.service;

import com.cargocompare.CargoCompare_api.commons.entities.TariffConditions;
import com.cargocompare.CargoCompare_api.companies.CompaniesRepository;
import com.cargocompare.CargoCompare_api.supplierCompany.dto.CreateSupplierCompanyResquest;
import com.cargocompare.CargoCompare_api.supplierCompany.service.SupplierCompanyService;
import com.cargocompare.CargoCompare_api.suppliers.SuppliersRepository;
import com.cargocompare.CargoCompare_api.tariffs.GeneralTariffRepository;
import com.cargocompare.CargoCompare_api.tariffs.TariffConditionRepository;
import com.cargocompare.CargoCompare_api.tariffs.dto.CreateTariffRequest;
import com.cargocompare.CargoCompare_api.tariffs.dto.GeneralTariffDTO;
import com.cargocompare.CargoCompare_api.tariffs.dto.TariffMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralTariffServiceImpl implements GeneralTariffService {

    private final GeneralTariffRepository generalTariffRepository;
    private final SupplierCompanyService supplierCompanyService;
    private final SuppliersRepository suppliersRepository;
    private final TariffConditionRepository tariffConditionsRepository;

    public GeneralTariffServiceImpl(GeneralTariffRepository generalTariffRepository, SupplierCompanyService supplierCompanyService, SuppliersRepository suppliersRepository, CompaniesRepository companiesRepository, TariffConditionRepository tariffConditionsRepository) {
        this.generalTariffRepository = generalTariffRepository;
        this.supplierCompanyService = supplierCompanyService;
        this.suppliersRepository = suppliersRepository;
        this.tariffConditionsRepository = tariffConditionsRepository;
    }


    @Override
    @Transactional
    public GeneralTariffDTO createTariff(CreateTariffRequest tariff) {
        return Optional.of(tariff)
                .map(TariffMapper::toEntity)
                .map(generalTariff -> {
                    var supplier = suppliersRepository.findById(tariff.getSupplierId())
                            .orElseThrow(() -> new RuntimeException("Error al crear la tarifa"));

                    generalTariff.setSupplier(supplier);

                    return generalTariff;
                })
                .map(generalTariffRepository::save)
                .map(tariffEntity -> {
                    if (tariff.getConditions() != null && !tariff.getConditions().isEmpty()) {
                        List<TariffConditions> conditions = tariff.getConditions().stream()
                                .map(cond -> TariffConditions.builder()
                                        .type(cond.getType())
                                        .factor(cond.getFactor())
                                        .generalTariffs(tariffEntity)
                                        .build())
                                .toList();
                        tariffConditionsRepository.saveAll(conditions);
                    }

                    CreateSupplierCompanyResquest supplierCompany = new CreateSupplierCompanyResquest();
                    supplierCompany.setSupplier(tariffEntity.getSupplier().getId());
                    supplierCompany.setLogisticCompany(tariff.getLogisticCompanyId());
                    supplierCompany.setTariffId(tariffEntity.getId());
                    supplierCompanyService.createSupplierCompany(supplierCompany);
                    return tariffEntity;
                })
                .map(TariffMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Error al crear la tarifa"));

    }
}
