package com.tamara.bankappli.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.model.Account;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class AccountService {

	@Autowired
	AccountRepository accountRepo;

	public List<Account> getAll(){
		
		log.info("Listing Accounts");
		
		return accountRepo.findAll();
	}
	
	public Account getByID(UUID id) {
		
		return accountRepo.getReferenceById(id);	
	}
	
	public List<Account> findByCustomerId(UUID id) {
		
		return accountRepo.findByCustomer(id);	
	}

	public String saveAccount(Account a) {
		
		UUID newAccId = accountRepo.save(a).getID();
		
		return "New account was successfully saved with ID = " + newAccId;	
	}
	
	public String deleteAccount(Account a) {
		
		accountRepo.delete(a);
		
		return "Account with ID was successfully deleted = " + a.getID();
	}
	
	public long countAccounts() {
		
		return accountRepo.count();
	}
}