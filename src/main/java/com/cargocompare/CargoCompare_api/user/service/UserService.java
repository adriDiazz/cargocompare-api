package com.cargocompare.CargoCompare_api.user.service;

import com.cargocompare.CargoCompare_api.user.User;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    List<UserDTO> getAllUsers();
}
