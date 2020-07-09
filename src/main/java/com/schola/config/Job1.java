package com.schola.config;

import com.schola.shared.utils.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Date;

@Component
public class Job1 implements Job {



    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job1 --->>> Time is " + new Date());

        EmailService.sendEmail("abdoukhadrndiaye99@gmail.com","test","test");
    }
}
