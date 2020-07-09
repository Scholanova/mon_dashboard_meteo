package com.schola.config;

import com.schola.entity.alert.Alert;
import com.schola.shared.utils.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class Job1 implements Job {


    public  LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job1 --->>> Time is " + convertToLocalDateTimeViaInstant(new Date()));

       // List<Alert> alertes = EmailService.getAlertes();

        //alertes.forEach(alert -> {
          //  if(alert.getIsReccurent() == false){
            //    System.out.println("dateSysteme" + convertToLocalDateTimeViaInstant(new Date()));
              //  System.out.println("dateAalert" + alert.getDate() );

                //if(alert.getDate().equals(convertToLocalDateTimeViaInstant(new Date()).toString()))
                  //  EmailService.sendEmail("magenelec@gmail.com",alert.getCaption(),"kATSANDE");
           // }
        //});

    }
}
