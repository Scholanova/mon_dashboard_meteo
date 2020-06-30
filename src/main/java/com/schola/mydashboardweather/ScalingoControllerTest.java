package com.schola.mydashboardweather;

import com.schola.mydashboardweather.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ScalingoControllerTest {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public User getFoosBySimplePath() {
        return new User("Equipe 2");
    }
}
