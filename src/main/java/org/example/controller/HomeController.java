package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/public-data")
    public String user() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin() {
        return "private-data";
    }

}
