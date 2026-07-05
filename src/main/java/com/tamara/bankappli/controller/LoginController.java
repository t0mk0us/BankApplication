package com.tamara.bankappli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@CrossOrigin(origins = "http://localhost:3015")
public class LoginController {
	    
	    @GetMapping("/login")
	    public String showLoginPage() {
	        return "login"; // Resolves to templates/login.html if using Thymeleaf
	    }
	}
