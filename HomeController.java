package com.example.loginsignup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showHomePage(Model model) {
        // Add any required data to the model for the home page
        model.addAttribute("welcomeMessage", "Welcome to the Home Page!");
        return "home";
    }
}
