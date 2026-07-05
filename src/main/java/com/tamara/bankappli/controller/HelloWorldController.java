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
	
	
	@GetMapping("/hello") 
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
	
	@GetMapping("/bankapplication/account/list")
	@CrossOrigin(origins = "http://localhost:3015")
		public List<Account> listAccounts() {
			
		return accountRepository.findAll();
		}
	
	@GetMapping("/bankapplication/account/count")
	@CrossOrigin(origins = "http://localhost:3015")
		public long countAccounts() {
			
		return accountRepository.count();
		}
	
	@GetMapping("/bankapplication/account/{id}")
	@CrossOrigin(origins = "http://localhost:3015")
	public Account findAccountById(@PathVariable Long id) { 
		System.out.println("Searching for accounts  with id " + id);
		  	return accountRepository.getReferenceById(id); 
	}
	
	@GetMapping("/bankapplication/account/by_owner/{ownerId}")  
	@CrossOrigin(origins = "http://localhost:3015")
		public List<Account> findAccountsByOwner (@PathVariable Long ownerId) {
			System.out.println("Searching for accounts of the person with id " + ownerId);
					
		return accountRepository.findByOwnerID(ownerId);
		}
	
	@GetMapping("/bankapplication/account/by_owner/{lastName}/{firstName}")  
	@CrossOrigin(origins = "http://localhost:3015")
		public List<Account> findAccountsByOwnerFirstNameAndLastNames (@PathVariable String firstName, @PathVariable String lastName) {
			System.out.println("Searching for accounts of  " + firstName + " " + lastName);
					
		return accountRepository.findByOwnerFirstNameAndLastName(firstName, lastName);
		}
	
	@GetMapping("/bankapplication/address/list")
	@CrossOrigin(origins = "http://localhost:3015")
		public List<Address> listAddresses() {
			
		return addressRepository.findAll();
		}
	
	@GetMapping("/bankapplication/currency/list")
	@CrossOrigin(origins = "http://localhost:3015")
		public List<Currency> listCurrencies() {
			
		return currencyRepository.findAll();
		}
	
	@GetMapping("/bankapplication/person/firstName/{firstName}/lastName/{lastName}")  
	@CrossOrigin(origins = "http://localhost:3015")
		public Person findPersonByFirstAndLast(@PathVariable String firstName, @PathVariable String lastName) {
			System.out.println("Searching for " + firstName + " and " + lastName);
					
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
		}
	
	@GetMapping("/bankapplication/login/{userName}/{userPass}")
	@CrossOrigin(origins = "http://localhost:3015")
		public String LoginGetRequest(@PathVariable String userName, @PathVariable String userPass) {
			
		Optional<BankUser> u = userRepository.findByUserNameAndPassword(userName, userPass);
		
		if (u != null) {
			
			System.out.println("Found User. Credentials are OK!");
			return "User " + userName + " logged successfully ";
			}
			else {
			
			return "Incorrect credentials for " + userName;
		}
	}
}