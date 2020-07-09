package com.schola.config;

import com.schola.shared.utils.EmailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class Job1 implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job1 --->>> Time is " + new Date());
        EmailUtil.sendEmail("abdoukhadrndiaye99@gmail.com","Email Testing Subject1", "Email Testing Body1");
    }
}
