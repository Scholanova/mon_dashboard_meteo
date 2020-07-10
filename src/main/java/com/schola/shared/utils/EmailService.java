package com.schola.shared.utils;

import com.schola.controller.user.UserController;
import com.schola.entity.alert.Alert;
import com.schola.entity.location.Location;
import com.schola.entity.location.LocationVM;
import com.schola.entity.user.User;
import com.schola.entity.weather.ConceptMeteoResponse;
import com.schola.repository.UserRepository;
import com.schola.services.LocationService;
import com.schola.services.UserLocationService;
import com.schola.services.alert.AlertService;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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


    @Autowired
    RestTemplate restemplate;

    private  UserRepository userRepository;
    UserLocationService userLocationService;

    private static String TOKEN = "f115ae23198fc26a272240ff66aeca014ca2aaed4c0314ec35e63ae6e96b7438";
    private static String DAYSEARCH = "0";



    public EmailService(JavaMailSender javaMailSender, UserLocationService userLocationService , AlertService alertService, UserRepository userRepository ,LocationService locationService) {
        this.javaMailSender = javaMailSender;
        this.alertService = alertService;
        this.locationService = locationService;
        this.userRepository =  userRepository;
        this.userLocationService = userLocationService ;
    }


    public static void sendEmail(String toEmail, String subject, String body) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);

    }

    public static List<Alert> getAlertes() {


        List<Alert> alerts = new ArrayList<>();
        alerts = alertService.listAll();

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

        List<Alert> alertes =  new ArrayList<>();

        alertes = EmailService.getAlertes();




            alertes.forEach(alert -> {



                if (alert.getIsReccurent() == null) {


                    if (alert.getDate().equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                    {

                        ConceptMeteoResponse responseMeteo;
                        List<Location> locations = new ArrayList<>();
                        locations = userLocationService.getUserLocations("magenelec@gmail.com");
                        List<LocationVM> locationVMS = new ArrayList<>();
                        for (int i = 0 ; i< locations.size();i++)
                        {
                            ConceptMeteoResponse conceptMeteoResponse ;
                            if(locations.get(i).getName().equals(alert.getLocationName()) == true){
                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                            }

                        }
                    }
                } else {

                    Calendar cal = Calendar.getInstance();
                    int day = cal.get(Calendar.DAY_OF_WEEK);
                    switch (day) {
                        case 1:
                            alert.getDayslist().forEach(s -> {
                                if(s.equals("Dimanche") == true){
                                    if(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();
                                       locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption(),"Bonjour , retrouver tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + "city: " + responseMeteo.getCity() + "date: "+ responseMeteo.getForecast().getDatetime() + "risque de brouillard: "+responseMeteo.getForecast().getProbafog() + "risque de froid: " + responseMeteo.getForecast().getProbafrost() +"risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + "heure de soleil: " + responseMeteo.getForecast().getSun_hours()+"Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
                                }
                            });                        break;
                        case 2:
                            alert.getDayslist().forEach(s -> {
                                if (s.equals("Lundi") == true) {
                                    System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                    if(convertToLocalDateTimeViaInstantReccurent(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();
                                        locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
                                }
                            });
                            break;
                        case 3:
                            alert.getDayslist().forEach(s -> {
                                if (s.equals("Mardi") == true) {
                                    System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                    if(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();

                                         locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
                                }
                            });
                            break;
                        case 4:
                            alert.getDayslist().forEach(s -> {
                                if (s.equals("Mercredi") == true) {
                                    System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                    if(convertToLocalDateTimeViaInstantReccurent(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();

                                        locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
                                }
                            });
                            break;
                        case 5:
                            alert.getDayslist().forEach(s -> {
                                if (s.equals("Jeudi") == true) {
                                    System.out.println(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())));
                                    if(convertToLocalDateTimeViaInstantReccurent(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();

                                        locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
                                }
                            });
                            break;
                        case 6:
                            alert.getDayslist().forEach(s -> {
                                if (s.equals("Vendredi") == true) {
                                    if(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();



                                        locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())== true){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
                                }
                            });
                            break;
                        case 7:
                            alert.getDayslist().forEach(s -> {
                                if (s.equals("Samedi") == true) {
                                    if(convertToLocalDateTimeViaInstantReccurentNoSec(cal.getTime()).concat("T".concat(alert.getHour())).equals(convertToLocalDateTimeViaInstantReccurent(new Date()).toString()))
                                    {
                                        ConceptMeteoResponse responseMeteo;
                                        List<Location> locations = new ArrayList<>();

                                        locations = userLocationService.getUserLocations("magenelec@gmail.com");
                                        List<LocationVM> locationVMS = new ArrayList<>();
                                        for (int i = 0 ; i< locations.size();i++)
                                        {
                                            ConceptMeteoResponse conceptMeteoResponse ;

                                            if(locations.get(i).getName().equals(alert.getLocationName())){
                                                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                                                EmailService.sendEmail("magenelec@gmail.com",alert.getCaption()," Bonjour , Vous trouverez tous les informations du météo de votre ville "+alert.getLocationName()
                                                        + " city: " + alert.getLocationName() + " date: "+ responseMeteo.getForecast().getDatetime() + " risque de brouillard: "+responseMeteo.getForecast().getProbafog() + " risque de froid: " + responseMeteo.getForecast().getProbafrost() +" risque de pluie: "+responseMeteo.getForecast().getProbarain()
                                                        + " heure de soleil: " + responseMeteo.getForecast().getSun_hours()+" Temperature max: "+responseMeteo.getForecast().getTmax()+"temperature min: "+responseMeteo.getForecast().getTmin());
                                            }

                                        }

                                    }
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
