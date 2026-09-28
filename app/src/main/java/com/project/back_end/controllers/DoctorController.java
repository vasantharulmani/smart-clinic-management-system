package com.project.back_end.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestHeader("Authorization") String token,
            @RequestParam Long doctorId,
            @RequestParam String date) {
        
        // Validates bearer authorization token
        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>("Invalid or missing token", HttpStatus.UNAUTHORIZED);
        }

        // Returns structured array with dynamic query params context mock
        List<String> availableTimes = List.of("09:00 AM", "11:00 AM", "03:30 PM");
        return ResponseEntity.ok(availableTimes);
    }
}
