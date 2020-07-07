package com.schola.controller.user;

import com.schola.services.UserService;
import com.schola.entities.Location;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableSpringDataWebSupport
@RequestMapping("/users")
public class  UserController {

    private UserService userService;

    @PostMapping("/{userId}/locations")
    public List<Location> listLocationsByUserId(@PathVariable long userId) {

        List<Location> locations = userService.getFavoritesLocations(userId);

        return  locations ;
    }

}
