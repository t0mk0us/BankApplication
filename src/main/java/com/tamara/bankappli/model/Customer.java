package com.tamara.bankappli.model;

import java.util.Date;
//import com.tamara.bankappli.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	enum customerType {
		PERSON,
		ENTERPRISE
	}
		  
	@Id @GeneratedValue
	@Column(name = "id")  
	private String ID;
	  
	@Column(name = "first_name")  
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "place_of_work")
	private String placeOfWork;
	
	@Column(name = "address")
	private Address address;
	
	@Column(name = "date_of_birth")
	private Date DOB;
		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPlaceOfWork() {
		return placeOfWork;
	}
	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
}
