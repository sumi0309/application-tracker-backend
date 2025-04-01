package com.example.applicationtrackerbackend.controller;

import com.example.applicationtrackerbackend.model.User;
import com.example.applicationtrackerbackend.repository.UserRepository;
import com.example.applicationtrackerbackend.services.UserService;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<String> createUser(@RequestBody User newUser) {
        try{
            if(userRepository.findByUsername(newUser.getUsername()).isPresent()){
                return ResponseEntity.status(409).body("Username Already Taken!");
            }
            String hashedPassword = userService.createHash(newUser.getPassword());
            newUser.setPassword(hashedPassword);
            userRepository.save(newUser);
            return ResponseEntity.ok("User Created!");
        }catch(Exception ex){
            return ResponseEntity.status(401).body("Something went wrong, please try again.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> retrieveUser(@RequestBody User newuser, HttpSession session) {
        User foundUser = userService.authenticateUser(newuser.getUsername(), newuser.getPassword());

        if (foundUser != null) {
            session.setAttribute("userId", foundUser.getUserID());
            return ResponseEntity.ok("Login Successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("Logged out Successfully.");
    }

}
