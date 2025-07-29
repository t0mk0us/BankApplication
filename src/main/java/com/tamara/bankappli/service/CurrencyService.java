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

import com.tamara.bankappli.model.Currency;
import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.repository.CurrencyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class CurrencyService {

	private final CurrencyRepository currencyRepo;
	
    public CurrencyService(CurrencyRepository currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

	public List<Currency> getAll() {
		
		log.info("Listing Currencys");
		
		return currencyRepo.findAll();
	}
	
	public Currency getByID(Long id) {	
		
		return currencyRepo.getReferenceById(id);	
	}
	
	public String saveCurrency(Currency c) {
		
		Long newCurrId = currencyRepo.save(c).getID();
		
		return "New currency was successfully saved with ID = " + newCurrId;		
	}
	
	public String deleteCurrency(Currency c) {
		
		currencyRepo.delete(c);
		
		return "Currency with ID was successfully deleted = " + c.getID();
	}
	
	public long countCurrencys() {
		
		return currencyRepo.count();
	}
}

