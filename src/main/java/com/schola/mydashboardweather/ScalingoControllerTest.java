package com.schola.mydashboardweather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScalingoControllerTest {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePath() {
        return "Testing";
    }
}
