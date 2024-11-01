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

import com.tamara.bankappli.model.Country;
import com.tamara.bankappli.model.Currency;
import com.tamara.bankappli.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class CountryService {

	@Autowired
	CountryRepository countryRepo;

	public List<Country> getAll() {
		
		log.info("Listing Countrys");
		
		return countryRepo.findAll();
	}
	
	public Country getByID(UUID id) {	
		
		return countryRepo.getReferenceById(id);	
	}
	
	public Country saveCountry(Country c) {
		
		return countryRepo.save(c);
	}
	
	public void deleteCountry(Country c) {
		
		countryRepo.delete(c);
		
		return;
	}
	
	public long countCountries() {
		
		return countryRepo.count();
	}
	
	public void addCurrency(UUID id, Currency c) {
		
		Country country = getByID(id); 
		
		List<Currency> currencies = country.getCurrencies();
		
		currencies.add(c);
		
		country.setCurrencies(currencies);
		
		countryRepo.save(country);
	}
}

