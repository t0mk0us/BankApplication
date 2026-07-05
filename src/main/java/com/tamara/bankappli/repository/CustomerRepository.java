package com.tamara.bankappli.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // FIX: Added underscores to clearly define the boundary of the 'owner' property
	Customer findByFirstNameAndLastName(String firstName, String lastName);
    
    // Also use the underscore strategy here to prevent future parsing issues
    Customer findByID(Long ownerId); 
}
