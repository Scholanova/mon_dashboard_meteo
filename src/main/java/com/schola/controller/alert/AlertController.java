package com.schola.controller.alert;

import com.schola.entity.location.Location;
import com.schola.entity.user.User;
import com.schola.repository.UserRepository;
import com.schola.entity.alert.Alert;
import com.schola.services.LocationService;
import com.schola.services.UserLocationService;
import com.schola.services.alert.AlertService;
import com.schola.shared.utils.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlertController {

    private AlertService alertService;
    private UserRepository userRepository;
    private UserLocationService userLocationService;
    private LocationService locationService;
    private EmailService emailService;


    public AlertController(AlertService alertService, UserRepository userRepository, EmailService emailService,UserLocationService userLocationService, LocationService locationService) {
        this.alertService = alertService;
        this.userRepository = userRepository;
        this.userLocationService = userLocationService;
        this.locationService = locationService;
        this.emailService = emailService;
    }

    @GetMapping("/alert")
    public String listAlert(Model model) {

        emailService.sendEmail("magenelec@gmail.com","Email Testing Subject2", "Email Testing Body2");

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


        model.addAttribute("alerts", alerts);
        //model.addAttribute("daysList",)
        return "alert/alert-list";
    }


    @RequestMapping("alert/{id}")
    public String deleteAlert(@PathVariable Integer id) {
        alertService.deleteAlert(id);
        return "redirect:/alert/alert-list";
    }

    @RequestMapping(value = "alert", method = RequestMethod.POST)
    public String saveAlert(@RequestParam(value = "caption", required = true) String caption,
                            @RequestParam(value = "isReccurent", required = false) Boolean isReccurent,
                            @RequestParam(value = "days", required = false) String days,
                            @RequestParam(value = "hour", required = false) String hour,
                            @RequestParam(value = "date", required = false) String date,
                            @RequestParam(value = "locationId", required = false) String locationId,
                            @RequestParam(value = "Lundi", required = false) Boolean lundi,
                            @RequestParam(value = "Mardi", required = false) Boolean Mardi,
                            @RequestParam(value = "Mercredi", required = false) Boolean Mercredi,
                            @RequestParam(value = "Jeudi", required = false) Boolean Jeudi,
                            @RequestParam(value = "Vendredi", required = false) Boolean Vendredi,
                            @RequestParam(value = "Samedi", required = false) Boolean Samedi,
                            @RequestParam(value = "Dimanche", required = false) Boolean Dimanche
    ) {

        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUsername(username);
        days = "";

        if (lundi != null)
            if (lundi.equals(true))
                days = days.concat("1");
        if (Mardi != null)
            if (Mardi.equals(true))
                days = days.concat("2");
        if (Mercredi != null)
            if (Mercredi.equals(true))
                days = days.concat("3");
        if (Jeudi != null)
            if (Jeudi.equals(true))
                days = days.concat("4");
        if (Vendredi != null)
            if (Vendredi.equals(true))
                days = days.concat("5");
        if (Samedi != null)
            if (Samedi.equals(true))
                days = days.concat("6");
        if (Dimanche != null)
            if (Dimanche.equals(true))
                days = days.concat("7");


        //Location location = locationService.findByName(locationId);

        Alert alert = new Alert(caption, isReccurent, days, hour, date, user.getIdUser(), Long.parseLong(locationId));
        alertService.saveAlert(alert);
        return "redirect:/alert";
    }

    @RequestMapping("alert/new")
    public ModelAndView newAlert(Model model) {
        model.addAttribute("myBooleanVariable", Boolean.FALSE);
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);
        List<Location> locations = userLocationService.getUserLocations(user.getUsername());
        model.addAttribute("locations", locations);
        return new ModelAndView("alert/alert-add");
    }


}