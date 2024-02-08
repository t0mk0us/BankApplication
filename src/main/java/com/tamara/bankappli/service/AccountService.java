package com.tamara.bankappli.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.model.Account;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {

	@Autowired
	AccountRepository accountRepo;

	public List<Account> getAll() {
		
		log.info("Listing Accounts");
		
		return accountRepo.findAll();
	}
	
	@SuppressWarnings("deprecation")
	public Account getByID(String id)
	{		
		return accountRepo.getReferenceById(id);	
	}
	
	@SuppressWarnings("deprecation")
	public Account saveAccount(Account a)
	{
		return accountRepo.save(a);	
	}
	
	public void deleteAccount(Account a) {
		
		accountRepo.delete(a);
		
		return;
	}
	
	public long countAccounts() {
		
		return accountRepo.count();
	}
}