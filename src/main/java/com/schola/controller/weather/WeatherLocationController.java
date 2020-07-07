package com.schola.controller.weather;

import com.schola.entity.weather.ConceptMeteoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WeatherLocationController {

    @Autowired
    RestTemplate restemplate;

    /*@GetMapping("/weatherlocation/{insee}")
    public String testMeteo(@PathVariable String insee){
        ConceptMeteoResponse response = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/0?token=f115ae23198fc26a272240ff66aeca014ca2aaed4c0314ec35e63ae6e96b7438&insee="+ insee, ConceptMeteoResponse.class);
        return response.getCity().getName();
    }*/

    @GetMapping("/weatherlocation/{insee}")
    public ModelAndView testMeteo(@PathVariable String insee, Model model) {
        ConceptMeteoResponse response = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/0?token=f115ae23198fc26a272240ff66aeca014ca2aaed4c0314ec35e63ae6e96b7438&insee="+ insee, ConceptMeteoResponse.class);
        model.addAttribute("response", response);
        return new ModelAndView("main/weatherlocation");
    }
}
