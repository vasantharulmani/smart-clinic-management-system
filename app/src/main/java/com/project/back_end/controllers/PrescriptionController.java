package com.project.back_end.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // POST endpoint saves a prescription with token and request body validation
    @PostMapping
    public ResponseEntity<?> savePrescription(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody Map<String, Object> prescriptionBody) {
        
        // Token Validation
        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>(Map.of("error", "Unauthorized: Missing or invalid token"), HttpStatus.UNAUTHORIZED);
        }

        // Request Body Validation
        if (prescriptionBody == null || !prescriptionBody.containsKey("medicationDetails")) {
            return new ResponseEntity<>(Map.of("error", "Bad Request: Medication details are required"), HttpStatus.BAD_REQUEST);
        }

        // Returns structured success messages using ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Prescription saved successfully", "status", "SUCCESS"));
    }
}
