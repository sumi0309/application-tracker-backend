package com.example.applicationtrackerbackend.controller;

import com.example.applicationtrackerbackend.model.User;
import com.example.applicationtrackerbackend.repository.UserRepository;
import com.example.applicationtrackerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/search")
    public ResponseEntity<User> retrieveUser(@RequestParam String username, @RequestParam String password) {
        User foundUser = userService.authenticateUser(username, password);

        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
