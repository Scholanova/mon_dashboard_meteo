package com.schola.config;

import com.schola.shared.utils.EmailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class Job2 implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job2 --->>> Time is " + new Date());
        EmailUtil.sendEmail("magenelec@gmail.com","Email Testing Subject2", "Email Testing Body2");
    }
}
