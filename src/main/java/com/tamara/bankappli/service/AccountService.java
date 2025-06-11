package com.tamara.bankappli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.repository.PersonRepository;

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
	
	private final AccountRepository accountRepo;
	
    @Autowired
    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

	public List<Account> getAll(){
		
		log.info("Listing Accounts");
		
		return accountRepo.findAll();
	}
	
	public Account getByID(Long id) {
		
		return accountRepo.getReferenceById(id);	
	}
	
	/*
	 * public List<Account> findByOwner(Long id) {
	 * 
	 * return findByOwnerID(id); }
	 * 
	 * public List<Account> findByOwnerID(Long id) {
	 * 
	 * return accountRepo.findByOwnerID(id); }
	 */

	public String saveAccount(Account a) {
		
		Long newAccId = accountRepo.save(a).getID();
		
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