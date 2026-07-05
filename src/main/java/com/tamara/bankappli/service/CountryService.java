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
import com.tamara.bankappli.model.Country;
import com.tamara.bankappli.model.Currency;
import com.tamara.bankappli.repository.CompanyRepository;
import com.tamara.bankappli.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class CountryService {
		
	private final CountryRepository countryRepo;
	
    public CountryService(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

	public List<Country> getAll() {
		
		log.info("Listing Countrys");
		
		return countryRepo.findAll();
	}
	
	public Country getByID(Long id) {	
		
		return countryRepo.getReferenceById(id);	
	}
	
	public String saveCountry(Country c) {
		
		Long newCntrId = countryRepo.save(c).getID();
        return "New country was successfully saved with ID = " + newCntrId;
	}
	
    public String deleteCountry(Country c) {
    	countryRepo.delete(c);
        return "Account with ID was successfully deleted = " + c.getID();
    }
    
	public long countCountries() {
		
		return countryRepo.count();
	}
	
	public Currency getCurrency(Long id) {
		
		Country country = getByID(id); 
		
		return country.getCurrency();
	}
}

