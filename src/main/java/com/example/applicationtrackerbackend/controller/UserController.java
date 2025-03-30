package com.example.applicationtrackerbackend.controller;

import com.example.applicationtrackerbackend.model.User;
import com.example.applicationtrackerbackend.repository.UserRepository;
import com.example.applicationtrackerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createuser")
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @PostMapping("/getuser")
    public ResponseEntity<User> retrieveUser(@RequestBody User newuser) {
        User foundUser = userService.authenticateUser(newuser.getUsername(), newuser.getPassword());

        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
