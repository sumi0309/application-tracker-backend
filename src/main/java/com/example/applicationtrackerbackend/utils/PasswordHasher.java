package com.example.applicationtrackerbackend.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class PasswordHasher {

    private final Argon2 argon2 = Argon2Factory.create();

    public String hashPassword(String password) {
        return argon2.hash(10, 65536, 1, password);
    }

    public boolean verifyPassword(String hashedPassword, String rawPassword) {
        return argon2.verify(hashedPassword, rawPassword);
    }
}
