package com.schola.controller.user;

import com.schola.entity.location.Location;
import com.schola.entity.location.LocationVM;
import com.schola.entity.user.User;
import com.schola.entity.weather.ConceptMeteoResponse;
import com.schola.repository.LocationRepository;
import com.schola.repository.UserRepository;
import com.schola.services.UserLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {


    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserLocationService userLocationService;

     static String TOKEN = "f115ae23198fc26a272240ff66aeca014ca2aaed4c0314ec35e63ae6e96b7438";
    private static String DAYSEARCH = "0";


    @Autowired
    RestTemplate restemplate;



    @GetMapping("/main")
    public ModelAndView acceuil (@AuthenticationPrincipal User user, Model model) {

        if(user == null)
            return new ModelAndView("redirect:" + "/");

        List<Location> locations = new ArrayList<>();

    locations = userLocationService.getUserLocations(user.getUsername());


        ConceptMeteoResponse responseMeteo;
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
}
