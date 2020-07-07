package com.schola.controller.alert;

import com.schola.repository.alert.AlertRepository;
import com.schola.entity.alert.Alert;
import com.schola.repository.alert.AlertRepository;
import com.schola.services.alert.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class AlertController {

    private AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/alertes")
    public String listAlert(Model model) {
        List<Alert> alerts = alertService.listAll();

        model.addAttribute("alerts", alerts);
        return "alert/alert-list";
    }


}