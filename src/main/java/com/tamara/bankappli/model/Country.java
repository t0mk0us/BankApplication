package com.tamara.bankappli.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.Continent;
import com.tamara.bankappli.enums.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {
	
	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private UUID ID;

	@Column(name = "symbol")  
	private String symbol;
	
	@Column(name = "name")  
	private String name;
	
	@Column(name = "currency")
	private Currency currency;
	
	@Column(name = "continent")
	private Continent continent;

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		
		ID = iD;
	}

	public String getSymbol() {
		
		return symbol;
	}

	public void setSymbol(String symbol) {
		
		this.symbol = symbol;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public Continent getContinent() {
		
		return continent;
	}

	public void setContinent(Continent continent) {
		
		this.continent = continent;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
