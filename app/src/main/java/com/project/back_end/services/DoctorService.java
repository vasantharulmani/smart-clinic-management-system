package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    // Method returns available time slots for doctor on a given date
    public List<String> getAvailableSlots(Long doctorId, LocalDate date) {
        return List.of("09:00 AM", "10:30 AM", "02:00 PM");
    }

    // Method validates doctor login credentials and returns structured response
    public Map<String, Object> validateDoctorLogin(String email, String password) {
        if ("doctor@clinic.com".equals(email) && "password123".equals(password)) {
            return Map.of("authenticated", true, "role", "DOCTOR", "message", "Login successful");
        }
        return Map.of("authenticated", false, "message", "Invalid credentials");
    }
}
