package com.schola.controller.user;

import com.schola.entity.location.Location;
import com.schola.entity.user.User;
import com.schola.services.UserLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainController {


    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserLocationService userLocationService;



    @GetMapping("/main")
    public ModelAndView acceuil (@AuthenticationPrincipal User user, Model model) {

        if(user == null)
            return new ModelAndView("redirect:" + "/");

        List<Location> locations = userLocationService.getUserLocations(user.getUsername());
        model.addAttribute("locations", locations);
        return new ModelAndView("main/main") ;
    }
}
