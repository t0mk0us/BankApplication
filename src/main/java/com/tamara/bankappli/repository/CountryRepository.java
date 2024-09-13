package com.tamara.bankappli.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Country;

@Repository
public interface CountryRepository 
	extends JpaRepository<Country, UUID>, JpaSpecificationExecutor<Country>{
	
	public Country findByName(String name);
	
	public Country findBySymbol(String symbol);

}
