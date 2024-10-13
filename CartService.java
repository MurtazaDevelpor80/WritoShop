package com.example.loginsignup.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<String> cartItems = new ArrayList<>();

    public void addItem(String item) {
        cartItems.add(item);
    }

    public List<String> getItems() {
        return cartItems;
    }
}
