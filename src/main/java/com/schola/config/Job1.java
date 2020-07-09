package com.schola.config;

import com.schola.shared.utils.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class Job1 implements Job {

    //@Autowired
    //private EmailService emailService;

    @Autowired
    private JavaMailSender sender;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job1 --->>> Time is " + new Date());

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo("magenelec@gmail.com");
            helper.setText("Greetings :)");
            helper.setSubject("Mail From Spring Boot");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }
       // emailService.sendEmail("abdoukhadrndiaye99@gmail.com","Email Testing Subject1", "Email Testing Body1");

}
