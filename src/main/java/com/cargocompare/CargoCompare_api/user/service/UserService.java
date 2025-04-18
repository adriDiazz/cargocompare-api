package com.cargocompare.CargoCompare_api.user.service;

import com.cargocompare.CargoCompare_api.user.User;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User findByEmail(String email);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(UUID id);
    UserDTO updateUser(UUID id, UserDTO userDTO);
    void deleteUser(UUID id);
}
