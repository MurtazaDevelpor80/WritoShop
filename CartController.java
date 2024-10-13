package com.example.loginsignup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class CartController {
    private List<String> cartItems = new ArrayList<>();

    @GetMapping("/cart")
    public String showCartPage(Model model) {
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(String item) {
        cartItems.add(item);
        return "redirect:/cart";
    }
}
