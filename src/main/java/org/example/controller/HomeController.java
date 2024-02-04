package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/public-data")
    public String user() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin() {
        return "private-data";
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        //model.addAttribute("signUpRequest");
        return "sign-up";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index"; // Имя Thymeleaf шаблона (без расширения .html)
    }

}
