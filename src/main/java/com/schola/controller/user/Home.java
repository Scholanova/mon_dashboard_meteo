package com.schola.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

public class Home {
    @GetMapping("/")
    public String accueilPage()
    {
        return "index";
    }
}
