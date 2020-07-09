package com.schola.shared.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private static JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }



    public static void sendEmail(String toEmail, String subject, String body){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);

    }

}
