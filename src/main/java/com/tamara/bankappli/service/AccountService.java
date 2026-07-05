package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.model.Account;
import lombok.extern.slf4j.Slf4j;

@Service // Cleaned up: Removed duplicate @Component annotation
@Slf4j
public class AccountService {
	
    private final AccountRepository accountRepo;
	
    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public List<Account> getAll() {
        log.info("Listing Accounts");
        return accountRepo.findAll();
    }
	
    public Account getByID(Long id) {
        return accountRepo.getReferenceById(id);	
    }

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
	
    // CLEANED UP: No more EntityManager, raw strings, or parameter binding errors!
    public List<Account> getByCustomerID(Long id) {
        log.info("Fetching accounts for customer ID: " + id);
        return accountRepo.findByOwner_ID(id);
    }
    
    public List<Account> getByOwnerFirstAndLast(String firstName, String lastName) {
        // Update this call to use the fixed repo method name
        return accountRepo.findByOwner_FirstNameAndOwner_LastName(firstName, lastName);
    }

}
