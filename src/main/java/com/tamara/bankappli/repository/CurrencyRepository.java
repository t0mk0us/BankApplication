package com.tamara.bankappli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.enums.Currency;

@Repository
public interface CurrencyRepository 
	extends JpaRepository<Currency, Long>, JpaSpecificationExecutor<Currency>{
	
	public Currency findByName(String name);
	
	public Currency findBySymbol(String symbol);

}
