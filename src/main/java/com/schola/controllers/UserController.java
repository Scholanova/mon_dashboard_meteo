package com.schola.controllers;

import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableSpringDataWebSupport
@RequestMapping("/users")
public class UserController {

    @PostMapping("/{userId}/location")
    public String getLocationsByUserId() {
        return "";
    }

}
