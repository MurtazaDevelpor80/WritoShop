package com.example.loginsignup.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // Defines MongoDB document
public class User {
    @Id
    private String id;  // MongoDB automatically creates unique _id
    private String email;
    private String password;

    // Getters and setters or use Lombok annotations
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
