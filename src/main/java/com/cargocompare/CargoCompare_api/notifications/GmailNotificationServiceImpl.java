package com.cargocompare.CargoCompare_api.notifications;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailNotificationServiceImpl implements GmailNotificationService{

    private final JavaMailSender mailSender;

    public GmailNotificationServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreplycomparecargo@gmail.com"); // Asegúrate de que este sea el mismo que el de spring.mail.username
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
