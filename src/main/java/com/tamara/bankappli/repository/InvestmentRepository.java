package com.tamara.bankappli.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tamara.bankappli.enums.InvestmentType;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    
    List<Investment> findByType(InvestmentType type);
    
    // Also use the underscore strategy here to prevent future parsing issues
    Investment findByID(Long id); 
    
    Investment findByName(String name);
}
