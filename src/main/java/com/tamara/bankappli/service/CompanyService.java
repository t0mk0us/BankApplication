package com.tamara.bankappli.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.model.Company;
import com.tamara.bankappli.model.Currency;
import com.tamara.bankappli.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class CompanyService {

	@Autowired
	CompanyRepository companyRepo;

	public List<Company> getAll() {
		
		log.info("Listing Companies");
		
		return companyRepo.findAll();
	}
	
	public Company getByID(Long id) {	
		
		return companyRepo.getReferenceById(id);	
	}
	
	public Company saveCompany(Company c) {
		
		return companyRepo.save(c);
	}
	
	public void deleteCompany(Company c) {
		
		companyRepo.delete(c);
		
		return;
	}
	
	public long countCompanies() {
		
		return companyRepo.count();
	}
	
	
/*	public void addCurrency(Long id, Currency c) {
		
		Company company = getByID(id); 
		
		List<Currency> currencies = company.getCurrencies();
		
		currencies.add(c);
		
		//company.setCurrencies(currencies);
		
		companyRepo.save(company);
	}
	*/
}

