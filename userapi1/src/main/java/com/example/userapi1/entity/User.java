package com.example.userapi1.entity;

import jakarta.validation.constraints.*;

public class User {

    @NotEmpty(message="Name must not be empty")
    private String name;

    @Email(message="Email must be valid")
    private String email;

    @Min(value=18,message="Age must be at least 18")
    private int age;

    private String username;
    private String password;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}