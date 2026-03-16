package com.example.userapi1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.userapi1.entity.User;

import jakarta.validation.Valid;

@RestController
public class UserController {

    // REGISTER API
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
        return ResponseEntity.status(201).body(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password){

        if(username.equals("admin") && password.equals("1234")){
            return ResponseEntity.ok("dummy-jwt-token-12345");
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}