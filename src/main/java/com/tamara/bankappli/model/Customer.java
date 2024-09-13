package com.tamara.bankappli.model;

import java.util.Date;
//import com.tamara.bankappli.model.Address;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	enum CustomerType { PERSON, ENTERPRISE } 
		  
	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private UUID ID;
	
	@Column(name = "customer_type")  
	private CustomerType customer_type;
	
	public UUID getID() {
		
		return ID;
	}

	public void setID(UUID iD) {
		
		ID = iD;
	}

	public CustomerType getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(CustomerType customer_type) {
		this.customer_type = customer_type;
	}
}
