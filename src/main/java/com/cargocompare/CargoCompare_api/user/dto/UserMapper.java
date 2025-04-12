package com.cargocompare.CargoCompare_api.user.dto;

import com.cargocompare.CargoCompare_api.companies.dto.CompanyMapper;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierMapper;
import com.cargocompare.CargoCompare_api.user.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        if (user.getLogisticCompany() != null) {
            userDTO.setLogisticCompany(CompanyMapper.toCompanyDTO(user.getLogisticCompany()));
        }
        if (user.getSupplier() != null) {
            userDTO.setSupplier(SupplierMapper.toSupplierDTO(user.getSupplier()));
        }
        userDTO.setId(user.getId());
        userDTO.setAuthorities(user.getAuthorities());
        return userDTO;
    }
}
