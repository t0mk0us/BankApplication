package com.tamara.bankappli.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tamara.bankappli.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
    // FIX: Added underscores to clearly define the boundary of the 'owner' property
    List<Account> findByOwner_FirstNameAndOwner_LastName(String firstName, String lastName);
    
    // Also use the underscore strategy here to prevent future parsing issues
    List<Account> findByOwner_ID(Long ownerId); 
}
