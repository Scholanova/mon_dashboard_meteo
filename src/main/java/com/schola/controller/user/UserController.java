package com.schola.controller.user;


import com.schola.entity.location.Location;
import com.schola.repository.UserRepository;
import com.schola.entity.user.Role;
import com.schola.entity.user.User;
import com.schola.services.UserLocationService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserLocationService userLocationService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public ModelAndView loginGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/main/main");
        }
        return new ModelAndView("/");
    }

    // Login form with error
    @GetMapping("/index-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }


    @GetMapping("/register")
    public ModelAndView getRegistred() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("authentification/register");
    }

    @GetMapping("/register-error")
    public String getRegistredWithError(Model model) {
        model.addAttribute("registrationError", true);

        return "authentification/register";
    }


    @PostMapping("/register")
    public ModelAndView postRegistred(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("firstName") String firstName,
                                      @RequestParam("lastName") String lastName) {
        try {
            User user = new User(username, password, firstName, lastName,Collections.singleton(Role.USER));
            userRepository.save(user);

            return new ModelAndView("redirect:" + "/");

        } catch (Exception e) {
            return new ModelAndView("redirect:" + "/register-error");
        }
    }

    @GetMapping("/locations")
    public ModelAndView listLocationsByUserId(@AuthenticationPrincipal User user, Model model) {

        List<Location> locations = userLocationService.getUserLocations(user.getUsername());
        model.addAttribute("locations", locations);

        return new ModelAndView("location/location-list") ;
    }
}
