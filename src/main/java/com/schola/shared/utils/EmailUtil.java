package com.schola.shared.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailUtil {

    @Autowired
    private static JavaMailSender javaMailSender;

    public static void sendEmail(String toEmail, String subject, String body){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);

    }

}
