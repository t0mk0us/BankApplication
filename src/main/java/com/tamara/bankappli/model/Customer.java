package com.tamara.bankappli.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.CustomerType;
import com.tamara.bankappli.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "CUSTOMER")
public class Customer {
		  
	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private Long ID;
	
	/*
	 * @Column(name = "customer_type") private CustomerType customer_type;
	 */
	
	public Long getID() {
		
		return ID;
	}

	public void setID(Long iD) {
		
		ID = iD;
	}
	
	@Column(name = "first_name") 
	private String firstName;
	
	@Column(name = "last_name") 
	private String lastName;
	
	@Column(name = "date_of_birth") 
	private Date dob;
	
	@OneToOne
    @JoinColumn(name = "place_of_work")
	private Company placeOfWork;
	
	@OneToOne
    @JoinColumn(name = "phone_id")
	private Phone phone;
	
	@OneToOne
    @JoinColumn(name = "address_id")
	private Address address;
	
	@Column(name = "user_name") 
	private String userName;
	
	@Column(name = "password") 
	private String password;
	/*
	 * public CustomerType getCustomer_type() { return customer_type; }
	 * 
	 * public void setCustomer_type(CustomerType customer_type) { this.customer_type
	 * = customer_type; }
	 */
}
