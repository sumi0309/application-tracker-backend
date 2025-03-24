package com.example.applicationtrackerbackend.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long userid;

    private String username;
    private String password;
    private String email;
    private String name;

    // Default constructor (important for JPA)
    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
    public long getUserID() { return userid; }
    public void setUserID(long userid) { this.userid = userid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
