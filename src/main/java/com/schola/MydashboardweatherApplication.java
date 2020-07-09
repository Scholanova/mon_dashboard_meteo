package com.schola;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schola.config.Job1;
import com.schola.config.Job2;
import com.schola.shared.utils.EmailService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class MydashboardweatherApplication{
	//@Autowired
	//private static EmailService emailService;

	@Bean
	ObjectMapper objectMapper(){
		return new ObjectMapper();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	public static void main(String[] args) {



		SpringApplication.run(MydashboardweatherApplication.class, args);



//		try {
//			JobDetail job1 = JobBuilder.newJob(Job1.class)
//					.withIdentity("job1", "group1").build();
//
//			Trigger trigger1 = TriggerBuilder.newTrigger()
//					.withIdentity("cronTrigger1", "group1")
//					.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
//					.build();
//
//			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
//			scheduler1.start();
//			scheduler1.scheduleJob(job1, trigger1);
//
//			JobDetail job2 = JobBuilder.newJob(Job2.class)
//					.withIdentity("job2", "group2").build();
//
//			Trigger trigger2 = TriggerBuilder.newTrigger()
//					.withIdentity("cronTrigger2", "group2")
//					.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/45 * * * * ?")))
//					.build();
//
//			Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
//			scheduler2.start();
//			scheduler2.scheduleJob(job2, trigger2);
//
//			Thread.sleep(100000);
//
//			scheduler1.shutdown();
//			scheduler2.shutdown();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
