package com.tamara.bankappli.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tamara.bankappli.enums.InvestmentType;
import com.tamara.bankappli.enums.PhoneType;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Investment;
import com.tamara.bankappli.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    
    // FIX: Added underscores to clearly define the boundary of the 'owner' property
    //List<Phone> findByOwner_FirstNameAndOwner_LastName(String firstName, String lastName);
    
    // Also use the underscore strategy here to prevent future parsing issues
    Phone findByID(Long id); 
    
    List<Phone> findByPhoneType(PhoneType type);
}
