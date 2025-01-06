package com.cargocompare.CargoCompare_api.auth;

import com.cargocompare.CargoCompare_api.commons.entities.AdminVerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminVerificationCodeRepository extends JpaRepository<AdminVerificationCode, Long> {
    AdminVerificationCode findByEmailAndCode(String email, String code);
    List<AdminVerificationCode> findByEmail(String email);
    void deleteByEmail(String email);
}