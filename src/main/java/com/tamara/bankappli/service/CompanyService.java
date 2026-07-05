package com.tamara.bankappli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Company;
import com.tamara.bankappli.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class CompanyService {
		
	private final CompanyRepository companyRepo;
	
    public CompanyService(CompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

	public List<Company> getAll() {
		
		log.info("Listing Companies");
		
		return companyRepo.findAll();
	}
	
	public Company getByID(Long id) {	
		
		return companyRepo.getReferenceById(id);	
	}
	
	public String saveCompany(Company c) {
		
		Long newCntrId = companyRepo.save(c).getID();
        return "New country was successfully saved with ID = " + newCntrId;
	}
	
    public String deleteCompany(Company c) {
    	companyRepo.delete(c);
        return "Account with ID was successfully deleted = " + c.getID();
    }
		
	public long countCompanies() {
		
		return companyRepo.count();
	}
}

