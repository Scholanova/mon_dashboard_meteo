package com.schola.controllers;

import org.springframework.ui.Model;
import com.schola.entities.Location;
import com.schola.services.UserLocationService;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableSpringDataWebSupport
@RequestMapping("/users")
public class  UserController {

    private UserLocationService userLocationService;

    @PostMapping("/{userId}/location")
    public String listLocationsByUserId(@PathVariable("userId")int userId, Model model) {

        List<Location> locations = userLocationService.listLocationByUserId(userId);

        model.addAttribute("locations", locations);
        return "location-list";
    }

}
