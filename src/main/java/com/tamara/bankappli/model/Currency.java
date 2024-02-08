package com.tamara.bankappli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency {
	
	@Id @GeneratedValue
	@Column(name = "id")  
	private String ID;

	@Column(name = "symbol")  
	private String symbol;
	
	@Column(name = "name")  
	private String name;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
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

}
