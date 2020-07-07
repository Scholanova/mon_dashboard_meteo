package com.schola.controller.user;


import com.schola.repository.UserRepository;
import com.schola.entity.user.Role;
import com.schola.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public ModelAndView loginGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                return new ModelAndView("redirect:/main");
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

}
