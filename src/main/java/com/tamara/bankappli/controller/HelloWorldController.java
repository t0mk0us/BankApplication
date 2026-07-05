package com.tamara.bankappli.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins = "http://localhost:3015")
	public class HelloWorldController   
{ 
	@RequestMapping("/home") 
	@CrossOrigin(origins = "http://localhost:3015")
		public String getHome()   
	{  
		return "Welcome to Tamara's Bank!";  
	}	
	
	
	@GetMapping("/bankapplication/hello") 
	@CrossOrigin(origins = "http://localhost:3015")
		public String getHello()   
	{  
		return "Hello User";  
	} 

	@GetMapping("/bankapplication/login") 
	@CrossOrigin(origins = "http://localhost:3015")
    public String loginPage() {
        return "forward:/login.html"; // Routes directly to your custom templates/login.html view
    }
}