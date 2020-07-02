package com.schola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.MBeanExporter;

@SpringBootApplication
public class MydashboardweatherApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(MydashboardweatherApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MydashboardweatherApplication.class, args);
    }
    @Bean
    public MBeanExporter exporter(){
        final  MBeanExporter exporter = new MBeanExporter();
        exporter.setAutodetect(true);
        exporter.setExcludedBeans("datasource");
        return exporter;
    }

}
