package com.schola.shared.utils;

import com.schola.entity.alert.Alert;
import com.schola.services.LocationService;
import com.schola.services.alert.AlertService;
import org.quartz.JobExecutionException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class EmailService {

    private static JavaMailSender javaMailSender;


    private static AlertService alertService;
    private static LocationService locationService;

    public EmailService(JavaMailSender javaMailSender, AlertService alertService, LocationService locationService) {
        this.javaMailSender = javaMailSender;
        this.alertService = alertService;
        this.locationService = locationService;
    }


    public static void sendEmail(String toEmail, String subject, String body) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);

    }

    public static List<Alert> getAlertes() {


        List<Alert> alerts = alertService.listAll();

        alerts.forEach(alert -> {
            alert.setLocationName(locationService.findById(alert.getLocationId()).get().getName());
            ArrayList<String> days = new ArrayList<>();
            for (int i = 0; i < alert.getDays().length(); i++) {
                String day = "" + alert.getDays().charAt(i);
                if (Integer.parseInt(day) == 1) {
                    days.add("Lundi");
                }
                if (Integer.parseInt(day) == 2) {
                    days.add("Mardi");
                }
                if (Integer.parseInt(day) == 3) {
                    days.add("Mercredi");
                }
                if (Integer.parseInt(day) == 4) {
                    days.add("Jeudi");
                }
                if (Integer.parseInt(day) == 5) {
                    days.add("Vendredi");
                }
                if (Integer.parseInt(day) == 6) {
                    days.add("Samedi");
                }
                if (Integer.parseInt(day) == 7) {
                    days.add("Dimanche");
                }


            }
            alert.setDayslist(days);
        });
        return alerts;
    }

    public String convertToLocalDateTimeViaInstant(Date dateToConvert) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(dateTimeFormatter);


        //.format(dateTimeFormatter);
    }

    public String convertToLocalDateTimeViaInstantReccurent(Date dateToConvert) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(dateTimeFormatter);


        //.format(dateTimeFormatter);
    }

    public String convertToLocalDateTimeViaInstantReccurentNoSec(Date dateToConvert) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(dateTimeFormatter);


        //.format(dateTimeFormatter);
    }


    @Scheduled(fixedRate = 30)
    public void cheekAlertes() throws JobExecutionException {
        System.out.println("Job1 --->>> Time is " + convertToLocalDateTimeViaInstant(new Date()));

        List<Alert> alertes = EmailService.getAlertes();

        alertes.forEach(alert -> {
            if (alert.getIsReccurent() == false) {
                System.out.println("dateSysteme" + convertToLocalDateTimeViaInstant(new Date()));
                System.out.println("dateAalert" + alert.getDate());

                if (alert.getDate().equals(convertToLocalDateTimeViaInstant(new Date()).toString()))
                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
            } else {
                System.out.println("dateSysteme" + convertToLocalDateTimeViaInstant(new Date()));
                System.out.println("dateAalert" + alert.getHour());

                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_WEEK);
                System.out.print("Today is ");
                switch (day) {
                    case 1:
                        System.out.print("Dimanche");
                        alert.getDayslist().forEach(s -> {
                            if(s.equals("Dimanche") == true){
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com",alert.getCaption(),"kATSANDE");
                            }
                        });                        break;
                    case 2:
                        System.out.print("Lundi");
                        alert.getDayslist().forEach(s -> {
                            if (s.equals("Lundi") == true) {
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if (convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
                            }
                        });
                        break;
                    case 3:
                        System.out.print("Mardi");
                        alert.getDayslist().forEach(s -> {
                            if (s.equals("Mardi") == true) {
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if (convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
                            }
                        });
                        break;
                    case 4:
                        System.out.print("Mercredi");
                        alert.getDayslist().forEach(s -> {
                            if (s.equals("Mercredi") == true) {
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if (convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
                            }
                        });
                        break;
                    case 5:
                        System.out.print("Jeudi");
                        alert.getDayslist().forEach(s -> {
                            if (s.equals("Jeudi") == true) {
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if (convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
                            }
                        });
                        break;
                    case 6:
                        System.out.print("Vendredi");
                        alert.getDayslist().forEach(s -> {
                            if (s.equals("Vendredi") == true) {
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if (convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
                            }
                        });
                        break;
                    case 7:
                        System.out.print("Samedi");
                        alert.getDayslist().forEach(s -> {
                            if (s.equals("Samedi") == true) {
                                System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                if (convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    EmailService.sendEmail("magenelec@gmail.com", alert.getCaption(), "kATSANDE");
                            }
                        });
                        break;
                }


            }
        });

    }

}

//10 SEC id user , id location ,username , ville
//check if date = date syteme is ok send
