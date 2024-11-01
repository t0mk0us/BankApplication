package com.tamara.bankappli.model;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.Continent;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
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
	
	@ManyToMany
	@ElementCollection
	@CollectionTable(name = "CURRENCY", joinColumns = @JoinColumn(name = "currency_id"))
	private List<Currency> currencies;
	
	@Column(name = "continent_id")
	private UUID continentId;
	
	@Column(name = "continent")
	private Continent continent;
	
	@Column(name = "country_code")
	private Short country_code;

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

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
}
