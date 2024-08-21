package com.tamara.bankappli.model;

import java.util.Date;
//import com.tamara.bankappli.model.Address;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
		  
	@Id @GeneratedValue
	@Column(name = "id")  
	private Long ID;
	
	@Column(name = "customer_type")  
	private CustomerType customer_type;
	
	public Long getID() {
		
		return ID;
	}

	public void setID(Long iD) {
		
		ID = iD;
	}

	public CustomerType getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(CustomerType customer_type) {
		this.customer_type = customer_type;
	}
}
