package com.example.loginsignup.repository;

import com.example.loginsignup.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email); // Custom query to find by email
}

