package com.schola.controller.user;


import com.schola.entity.location.Location;
import com.schola.entity.location.LocationResponse;
import com.schola.entity.location.LocationVM;
import com.schola.entity.weather.ConceptMeteoResponse;
import com.schola.repository.LocationRepository;
import com.schola.repository.UserRepository;
import com.schola.entity.user.Role;
import com.schola.entity.user.User;
import com.schola.services.UserLocationService;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserLocationService userLocationService;
    private static String TOKEN = "f115ae23198fc26a272240ff66aeca014ca2aaed4c0314ec35e63ae6e96b7438";
    private static String DAYSEARCH = "0";


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    RestTemplate restemplate;

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

    @GetMapping("/favorites-locations")
    public ModelAndView listLocationsByUserId(@AuthenticationPrincipal User user, Model model) {

        if(user == null)
            return new ModelAndView("redirect:" + "/");


        ConceptMeteoResponse responseMeteo;
        List<Location> locations = userLocationService.getUserLocations(user.getUsername());
        List<LocationVM> locationVMS = new ArrayList<>();
        for (int i = 0 ; i< locations.size();i++)
        {
            ConceptMeteoResponse conceptMeteoResponse ;

                responseMeteo = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/" + DAYSEARCH + "?token=" + TOKEN + "&insee="+ locations.get(i).getInsee(), ConceptMeteoResponse.class);
                conceptMeteoResponse = responseMeteo;
                LocationVM locationVM = LocationVM.builder()
                        .id(locations.get(i).getId())
                        .insee(locations.get(i).getInsee())
                        .name(locations.get(i).getName())
                        .response(conceptMeteoResponse)
                        .build();
                locationVMS.add(locationVM);
            //locations.get(i).setResponse(conceptMeteoResponse);
        }


        model.addAttribute("locations", locationVMS);

        return new ModelAndView("main/main") ;
    }

    @GetMapping("/favorites-locations/delete/{id}")
    public String deleteFavoriteLocation(@AuthenticationPrincipal User user, @PathVariable("id") long id) {

        logger.info("id param: " + id);
        userLocationService.removeFavoriteLocation(user.getUsername(), id);

        return "redirect:/favorites-locations";
    }

    @PostMapping("/favorites-locations/add")
    public String addFavoriteLocation(
            @AuthenticationPrincipal User user,
            @RequestParam("cityName") String cityName,
            @RequestParam("cityInsee") String cityInsee
    )
    {
        logger.info("param1 : " + cityName);
        logger.info("param2 : " + cityInsee);
        userLocationService.addFavoriteLocation(user.getUsername(), cityName, cityInsee);

        return "redirect:/favorites-locations";
    }

}
