package com.schola.controller.alert;

import com.schola.entity.user.User;
import com.schola.repository.UserRepository;
import com.schola.repository.alert.AlertRepository;
import com.schola.entity.alert.Alert;
import com.schola.repository.alert.AlertRepository;
import com.schola.services.alert.AlertService;
import com.schola.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Controller
public class AlertController {

    private AlertService alertService;
    private UserRepository userRepository;


    public AlertController(AlertService alertService, UserRepository userRepository) {
        this.alertService = alertService;
        this.userRepository = userRepository;
    }

    @GetMapping("/alert")
    public String listAlert(Model model) {
        List<Alert> alerts = alertService.listAll();

        model.addAttribute("alerts", alerts);
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


        Alert alert = new Alert(caption, isReccurent, days, hour, date, user.getIdUser(), 1L);
        alertService.saveAlert(alert);
        return "redirect:/alert";
    }

    @RequestMapping("alert/new")
    public ModelAndView newAlert(Model model) {
        model.addAttribute("myBooleanVariable", Boolean.FALSE);
        return new ModelAndView("alert/alert-add");
    }


}