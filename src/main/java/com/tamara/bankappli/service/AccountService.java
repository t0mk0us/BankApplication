package com.tamara.bankappli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.repository.PersonRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

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
	
	public Long countAccounts() {
		
		return accountRepo.count();
	}
	
	public List<Account> getByCustomerID(Long id) {
		
	      String jpql = "SELECT a FROM Account a, Customer c" +
        		  "  WHERE c.id :id" +
        		  "	AND a.owner.ID = c.ID";
	      
	        // Create the query
	        Query query = em.createQuery(jpql);

	        // Set the parameter value
	        query.setParameter("id", id);

	        // Execute the query and get the results
	        return query.getResultList();
	}
	
    private EntityManager em; // Injected or obtained EntityManager

    public List<Account> getAccountByFirstAndLastNames(String fName, String lName) {
    	
    	// "SELECT c FROM Customer c JOIN c.orders o WHERE o.orderDate > :minOrderDate AND c.name LIKE :customerName"
        // JPQL query with a JOIN and a named parameter
        String jpql = "SELECT a FROM Account a, Customer c" +
        		  "  WHERE c.firstName :firstName AND c.lastName :lastName" +
        		  "	AND a.owner.ID = c.ID";

        // Create the query
        Query query = em.createQuery(jpql);

        // Set the parameter value
        query.setParameter("firstName", fName);
        query.setParameter("lastName", lName);

        // Execute the query and get the results
        return query.getResultList();
    }
    
    public List<Account> getByOwnerFirstAndLast(String firstName, String lastName) {
    	
    	return accountRepo.findByOwnerFirstNameAndLastName(firstName, lastName);
    }
}
