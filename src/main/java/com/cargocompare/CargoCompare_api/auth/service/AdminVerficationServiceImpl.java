package com.cargocompare.CargoCompare_api.auth.service;

import com.cargocompare.CargoCompare_api.auth.AdminVerificationCodeRepository;
import com.cargocompare.CargoCompare_api.commons.entities.AdminVerificationCode;
import com.cargocompare.CargoCompare_api.notifications.GmailNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AdminVerficationServiceImpl implements AdminVerificationService{

    private final AdminVerificationCodeRepository verificationCodeRepository;
    private final GmailNotificationService gmailNotificationService;

    public AdminVerficationServiceImpl(AdminVerificationCodeRepository verificationCodeRepository, GmailNotificationService gmailNotificationService) {
        this.verificationCodeRepository = verificationCodeRepository;
        this.gmailNotificationService = gmailNotificationService;
    }

    // Genera un código de 6 dígitos
    public String generateVerificationCode(String email) {
        var alreadyExistingCode = verificationCodeRepository.findByEmail(email);

        if (alreadyExistingCode != null) {
            for (AdminVerificationCode code : alreadyExistingCode) {
                code.setUsed(true);
                verificationCodeRepository.save(code);
            }
        }

        return String.format("%06d", new Random().nextInt(999999));
    }



    // Verifica el código ingresado por el usuario
    public boolean verifyCode(String email, String code) {
        AdminVerificationCode verificationCode = verificationCodeRepository.findByEmailAndCode(email, code);

        if (verificationCode != null && !verificationCode.getUsed() &&
                verificationCode.getExpirationTime().isAfter(LocalDateTime.now())) {
            verificationCode.setUsed(true);
            verificationCodeRepository.save(verificationCode);
            return true;
        }

        return false;
    }

    @Override
    public void sendVerificationCode(String email, String code) {
        gmailNotificationService.sendSimpleEmail(email, "CargoCompare codigo de verificacion", code);
    }

    @Override
    public void saveCode(String email, String code) {
        AdminVerificationCode verificationCode = new AdminVerificationCode();

        verificationCode.setEmail(email);
        verificationCode.setCode(code);
        verificationCode.setExpirationTime(LocalDateTime.now().plusMinutes(10)); // expira en 10 minutos
        verificationCode.setUsed(false);
        verificationCodeRepository.save(verificationCode);
    }
}
