package com.tamara.bankappli.model;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "COUNTRY")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long ID;

	@Column(name = "symbol")  
	private String symbol;
	
	@Column(name = "name")  
	private String name;
	
	//@ManyToMany
	//@ElementCollection
	//@CollectionTable(name = "CURRENCY", joinColumns = @JoinColumn(name = "currency_id"))
	//private List<Currency> currencies;
	
	@OneToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	@OneToOne
	@JoinColumn(name = "continent_id")
	private Continent continent;
	
	@Column(name = "country_code_id")
	private short country_code;
	
	public Country() {
		
	}
	
	public Country(String symbol, String name, Currency currency, Continent continent, short country_code) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.currency = currency;
		this.continent = continent;
		this.country_code = country_code;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		
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

	public short getCountry_code() {
		return country_code;
	}

	public void setCountry_code(short country_code) {
		this.country_code = country_code;
	}

	/*
	 * public List<Currency> getCurrencies() { return currencies; }
	 * 
	 * public void setCurrencies(List<Currency> currencies) { this.currencies =
	 * currencies; }
	 */
}
