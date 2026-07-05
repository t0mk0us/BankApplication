package com.tamara.bankappli.controller;

import com.tamara.bankappli.dto.LoginRequest;
import com.tamara.bankappli.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3015")
@RequestMapping(value = AuthController.CONTEXT_1)
public class AuthController {
	
	public static final String CONTEXT_1 = "/bankapplication/"; 
	//public static final String CONTEXT_V1_Auth = CONTEXT_1 + "auth";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        
        // TEMPORARY placeholder logic - Replace this with your actual DB/Service check!
        if ("tamara".equals(loginRequest.getUsername()) && "password123".equals(loginRequest.getPassword())) {
            
            // Return dummy database mapping customerId = 99L
            LoginResponse response = new LoginResponse(loginRequest.getUsername(), 99L);
            return ResponseEntity.ok(response);
        }
        
        // Return unauthorized status if credentials don't match
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
