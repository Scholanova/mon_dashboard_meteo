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
    public String saveAlert(@RequestParam(value = "caption",required = true) String caption,
                            @RequestParam(value = "isReccurent",required = false)  Boolean isReccurent,
                            @RequestParam(value = "days",required = false) String days,
                            @RequestParam(value = "hour",required = false) String hour,
                            @RequestParam(value = "date",required = false) String date,
                            @RequestParam(value = "locationId",required = false) String locationId
    ) {

        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUsername(username);



        Alert alert = new Alert(caption, isReccurent, days, hour, date, user.getIdUser(), 1L);
        alertService.saveAlert(alert);
        return "redirect:/alert";
    }

    @RequestMapping("alert/new")
    public ModelAndView newAlert(Model model) {
        model.addAttribute("myBooleanVariable",Boolean.FALSE);
        return new ModelAndView("alert/alert-add");
    }


}