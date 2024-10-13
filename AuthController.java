package com.example.loginsignup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    // Simulated in-memory user data (username: password)
    private Map<String, String> users = new HashMap<>();

    public AuthController() {
        // Adding some users
        users.put("murtaza", "murtaza123");
        users.put("arham", "arham123");
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        String storedPassword = users.get(username);

        if (storedPassword != null && storedPassword.equals(password)) {
            // Password matches, redirect to home page
            return "redirect:/home";
        } else {
            // Password incorrect or user not found
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestParam String username, @RequestParam String password, Model model) {
        if (!users.containsKey(username)) {
            // Add new user to the in-memory list
            users.put(username, password);
            model.addAttribute("message", "User " + username + " signed up successfully");
        } else {
            // User already exists
            model.addAttribute("error", "User " + username + " already exists");
        }
        return "signup";
    }
}
