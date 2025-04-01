package com.example.applicationtrackerbackend.services;

import com.example.applicationtrackerbackend.model.User;
import com.example.applicationtrackerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.applicationtrackerbackend.utils.PasswordHasher;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordHasher passwordHasher;

    public final String createHash(String password){
        return passwordHasher.hashPassword(password);
    }

    public User authenticateUser(String username, String rawPassword) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            boolean matched = passwordHasher.verifyPassword(user.get().getPassword(),rawPassword);
            if(matched){
                return user.get();
            }
        }
        return null;
    }
}
