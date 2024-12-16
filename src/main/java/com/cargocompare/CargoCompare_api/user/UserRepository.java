package com.cargocompare.CargoCompare_api.user;

import com.cargocompare.CargoCompare_api.commons.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
