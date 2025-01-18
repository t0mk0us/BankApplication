package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.repository.AddressRepository;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;

@RestController 
@CrossOrigin(origins = "http://localhost:3000")
	public class HelloWorldController   
{  
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
@RequestMapping("/")  
	public String hello()   
{  
	return "Hello User";  
} 

@RequestMapping("/bankapplication/account/list")
@CrossOrigin(origins = "http://localhost:3000")
	public List<Account> listAccounts() {
		
	return accountRepository.findAll();
	}

@RequestMapping("/bankapplication/address/list")
@CrossOrigin(origins = "http://localhost:3000")
	public List<Address> listAddresses() {
		
	return addressRepository.findAll();
	}
}  