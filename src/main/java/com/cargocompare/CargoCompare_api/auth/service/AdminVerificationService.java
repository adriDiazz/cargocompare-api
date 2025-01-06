package com.cargocompare.CargoCompare_api.auth.service;

import com.cargocompare.CargoCompare_api.commons.entities.AdminVerificationCode;

public interface AdminVerificationService {
    String generateVerificationCode(String email);
    boolean verifyCode(String email, String code);
    void sendVerificationCode(String email, String code);
    void saveCode(String email, String code);
}
