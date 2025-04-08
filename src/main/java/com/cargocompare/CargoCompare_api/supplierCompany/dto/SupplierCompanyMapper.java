package com.cargocompare.CargoCompare_api.supplierCompany.dto;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierMapper;

public class SupplierCompanyMapper {

    public static SupplierCompanyDTO toDTO(SupplierCompany supplierCompany) {
        SupplierCompanyDTO supplierCompanyDTO = new SupplierCompanyDTO();
        supplierCompanyDTO.setId(supplierCompany.getId());
        supplierCompanyDTO.setLogisticCompany(supplierCompany.getLogisticCompany().getId());


        supplierCompanyDTO.setSupplier(SupplierMapper.toSupplierDTO(supplierCompany.getSupplier()));
        supplierCompanyDTO.setTariffId(supplierCompany.getTariffId());
        return supplierCompanyDTO;
    }


    public static SupplierCompany toEntity(SupplierCompanyDTO supplierCompanyDTO) {
        SupplierCompany supplierCompany = new SupplierCompany();
        supplierCompany.setId(supplierCompanyDTO.getId());
        supplierCompany.setSupplier(SupplierMapper.toSupplier(supplierCompanyDTO.getSupplier()));
        supplierCompany.setTariffId(supplierCompanyDTO.getTariffId());
        return supplierCompany;
    }

    public static SupplierCompany toEntity(CreateSupplierCompanyResquest supplierCompanyDTO) {
        SupplierCompany supplierCompany = new SupplierCompany();
        supplierCompany.setId(supplierCompanyDTO.getId());
        supplierCompany.setTariffId(supplierCompanyDTO.getTariffId());
        return supplierCompany;
    }


}
