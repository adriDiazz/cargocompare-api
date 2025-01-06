package com.cargocompare.CargoCompare_api.notifications;

public interface GmailNotificationService {
    void sendSimpleEmail(String to, String subject, String text);
}
