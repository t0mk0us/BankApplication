package com.tamara.bankappli.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.repository.AccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class AccountService {
	
	 @PersistenceContext // or even @Autowired
	 private EntityManager entityManager;

	@Autowired
	AccountRepository accountRepo;

	public List<Account> getAll(){
		
		log.info("Listing Accounts");
		
		return accountRepo.findAll();
	}
	
	public Account getByID(UUID id) {
		
		return accountRepo.getReferenceById(id);	
	}
	
	public List<Account> findByOwner(Customer c) {
		
		return findByOwnerID(c.getID());
	}
	
	public List<Account> findByOwnerID(UUID id) {
		
		return accountRepo.findByOwnerID(id);	
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