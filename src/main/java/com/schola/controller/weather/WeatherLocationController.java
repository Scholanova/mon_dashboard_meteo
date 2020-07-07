package com.schola.controller.weather;

import com.schola.entity.weather.ConceptMeteoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherLocationController {

    @Autowired
    RestTemplate restemplate;

    @GetMapping("/testmeteo")
    public String testMeteo(){
        ConceptMeteoResponse response = restemplate.getForObject("https://api.meteo-concept.com/api/forecast/daily/0?token=f115ae23198fc26a272240ff66aeca014ca2aaed4c0314ec35e63ae6e96b7438&insee=75111", ConceptMeteoResponse.class);
        return response.getCity().getName();
    }
}
