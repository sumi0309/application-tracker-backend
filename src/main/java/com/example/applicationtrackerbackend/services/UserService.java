package com.example.applicationtrackerbackend.services;

import com.example.applicationtrackerbackend.model.User;
import com.example.applicationtrackerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String username, String rawPassword) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(rawPassword)) {
            return user.get();
        }
        return null;
    }
}
