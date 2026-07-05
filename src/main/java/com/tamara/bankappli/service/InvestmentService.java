package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.InvestmentRepository;
import com.tamara.bankappli.enums.InvestmentType;
import com.tamara.bankappli.model.Investment;
import lombok.extern.slf4j.Slf4j;

@Service // Cleaned up: Removed duplicate @Component annotation
@Slf4j
public class InvestmentService {
	
    private final InvestmentRepository investmentRepo;
	
    public InvestmentService(InvestmentRepository investmentRepo) {
        this.investmentRepo = investmentRepo;
    }

    public List<Investment> getAll() {
        log.info("Listing Investments");
        return investmentRepo.findAll();
    }
	
    public Investment getByID(Long id) {
        return investmentRepo.getReferenceById(id);	
    }
    
    public List<Investment> getByType(Long type) {
    	InvestmentType invstType = InvestmentType.getById(type);
        return investmentRepo.findByType(invstType);	
    }

    public String saveInvestment(Investment a) {
        Long newAccId = investmentRepo.save(a).getId();
        return "New investment was successfully saved with ID = " + newAccId;	
    }
	
    public String deleteInvestment(Investment a) {
        investmentRepo.delete(a);
        return "Investment with ID was successfully deleted = " + a.getId();
    }
	
    public Long countInvestments() {
        return investmentRepo.count();
    }
}
