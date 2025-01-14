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


}
