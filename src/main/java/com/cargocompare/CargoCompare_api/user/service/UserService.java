package com.cargocompare.CargoCompare_api.user.service;

import com.cargocompare.CargoCompare_api.user.User;

import java.util.Optional;

public interface UserService {
    User findByEmail(String email);
}
