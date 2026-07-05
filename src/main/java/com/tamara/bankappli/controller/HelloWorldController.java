package com.tamara.bankappli.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.repository.AddressRepository;
import com.tamara.bankappli.repository.CurrencyRepository;
import com.tamara.bankappli.repository.PersonRepository;
import com.tamara.bankappli.repository.BankUserRepository;
import com.tamara.bankappli.service.AccountService;

import lombok.extern.java.Log;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.model.Currency;
import com.tamara.bankappli.model.Customer;
import com.tamara.bankappli.model.Person;
import com.tamara.bankappli.model.BankUser;

@RestController 
@CrossOrigin(origins = "http://localhost:3015")
	public class HelloWorldController   
{  
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	BankUserRepository userRepository;
	
	@Autowired
	AccountService accountService;
	
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