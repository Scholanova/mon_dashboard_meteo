package com.schola.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String accueilPage()
    {
        return "index";
    }
}
