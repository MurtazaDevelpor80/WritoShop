package com.example.loginsignup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private Map<String, String> adminUsers = new HashMap<>();
    private List<String> salesData = new ArrayList<>();

    public AdminController() {
        // Adding a sample admin user
        adminUsers.put("admin", "admin123");
    }

    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "admin_login";  // Ensure admin_login.html exists in the templates directory
    }

    @PostMapping("/admin/login")
    public String handleAdminLogin(@RequestParam String username, @RequestParam String password, Model model) {
        String storedPassword = adminUsers.get(username);

        if (storedPassword != null && storedPassword.equals(password)) {
            return "redirect:/admin/sales";  // Redirect to the sales page after successful login
        } else {
            model.addAttribute("error", "Invalid admin username or password");
            return "admin_login";  // Return to login page with error
        }
    }

    @GetMapping("/admin/sales")
    public String showSalesPage(Model model) {
        model.addAttribute("salesData", salesData);  // Pass sales data to the view
        return "admin_sales";  // Ensure admin_sales.html exists in the templates directory
    }

    // Method to simulate adding sales data (this can be extended)
    public void addSale(String sale) {
        salesData.add(sale);  // Add a sale to the list
    }
}
