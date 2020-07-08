package com.schola.controller.location;

import com.schola.entity.location.LocationResponse;
import org.springframework.web.bind.annotation.RestController;
import com.schola.entity.weather.ConceptMeteoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class FindLocationController {

    @Autowired
    RestTemplate restemplate;

    /*@GetMapping("/findlocation/{name}")
    public String FindLocationByName(@PathVariable String name){
        LocationResponse[] response = restemplate.getForObject("https://geo.api.gouv.fr/communes?nom="+name, LocationResponse[].class);
        return response[0].getNom() + "  Insee = " + response[0].getCode();
    }*/

    @GetMapping("/findlocation/{name}")
    public ModelAndView FindLocationByName (@PathVariable String name, Model model) {
        LocationResponse[] response = restemplate.getForObject("https://geo.api.gouv.fr/communes?nom="+name, LocationResponse[].class);
        model.addAttribute("response", response);
        return new ModelAndView("location/findlocation");
    }
}
