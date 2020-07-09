package com.schola.config;

import com.schola.shared.utils.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Job2 implements Job {

    @Autowired
    private EmailService emailService;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job2 --->>> Time is " + new Date());
        emailService.sendEmail("magenelec@gmail.com","Email Testing Subject2", "Email Testing Body2");
    }
}
