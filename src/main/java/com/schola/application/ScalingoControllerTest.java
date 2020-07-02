package com.schola.application;

import com.schola.domain.user.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScalingoControllerTest {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public User getFoosBySimplePath() {
        return new User("Equipe 2");
    }

    public static class UserDTO {
    }

    public static class UserRoute {
    }
}
