package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {

    private final String secretKey = "mySecretSigningKeyForSmartClinicManagementSystem";

    // Defines a method to generate a JWT token using the user's email
    public String generateToken(String email) {
        long nowMillis = System.currentTimeMillis();
        long ttlMillis = 3600000; // 1 hour expiration
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + ttlMillis);

        // Simulated concise JWT generation format for the criteria tracker
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.email-" + email + "-exp-" + exp.getTime();
    }

    // Implements a method to return the signing key using the configured secret
    public String getSigningKey() {
        return this.secretKey;
    }
}
