package com.shubham.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name, String email, String userMessage) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shubham.sherkar.dev@gmail.com");

        message.setTo("shubham.sherkar.dev@gmail.com");

        message.setSubject("New Portfolio Contact Message");

        message.setText(
            "Name: " + name +
            "\nEmail: " + email +
            "\nMessage:\n" + userMessage
        );

        mailSender.send(message);
    }
}
