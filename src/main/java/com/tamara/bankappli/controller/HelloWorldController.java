package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.repository.AddressRepository;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;

@RestController 
@CrossOrigin(origins = "http://localhost:3015")
	public class HelloWorldController   
{  
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
@RequestMapping("/hello") 
@CrossOrigin(origins = "http://localhost:3015")
	public String hello()   
{  
	return "Hello User";  
} 

@RequestMapping("/bankapplication/account/list")
@CrossOrigin(origins = "http://localhost:3015")
	public List<Account> listAccounts() {
		
	return accountRepository.findAll();
	}

@RequestMapping("/bankapplication/account/count")
@CrossOrigin(origins = "http://localhost:3015")
	public long countAccounts() {
		
	return accountRepository.count();
	}

@GetMapping("/bankapplication/account/{id}")
@CrossOrigin(origins = "http://localhost:3015")
public Account findAccountById(@PathVariable Long id) { 
	  	return accountRepository.getReferenceById(id); 
}

@RequestMapping("/bankapplication/address/list")
@CrossOrigin(origins = "http://localhost:3015")
	public List<Address> listAddresses() {
		
	return addressRepository.findAll();
	}
}  