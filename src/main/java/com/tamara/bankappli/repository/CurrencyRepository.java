package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Country;
import com.tamara.bankappli.model.Currency;

@Component
@Repository
public interface CurrencyRepository 
	extends JpaRepository<Currency, UUID>, JpaSpecificationExecutor<Currency>{
	
	public Currency findByName(String name);
	
	public Currency findBySymbol(String symbol);
	
	public Currency findByCode(String code);

}
