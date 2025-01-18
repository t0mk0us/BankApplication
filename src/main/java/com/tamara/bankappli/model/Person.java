package com.tamara.bankappli.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "PERSON")
public class Person {
	
	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private Long ID;
		
	@Column(name = "first_name")  
	private String firstName;
		
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private Gender gender;
	
	@OneToOne
	@JoinColumn(name = "place_of_work")
	private Company placeOfWork;
		
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
		
	@OneToMany
	@JoinColumn(name = "phone_id")
	private List<Phone> phones;
		
	@Column(name = "dob")
	private Date DOB;
		
	@OneToMany
	@JoinColumn(name = "account_id")
	private List<Account> accounts;
	
	@Column(name = "is_customer")
	private boolean isCustomer;
	
	@Column(name = "is_employee")
	private boolean isEmployee;

	public Long getID() {
		
		return ID;
	}

	public void setID(Long iD) {
		
		ID = iD;
	}

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

	public Gender getGender() {
		
		return gender;
	}

	public void setGender(Gender gender) {
		
		this.gender = gender;
	}

	public Company getPlaceOfWork() {
		
		return placeOfWork;
	}

	public void setPlaceOfWork(Company placeOfWork) {
		
		this.placeOfWork = placeOfWork;
	}

	public Address getAddress() {
		
		return address;
	}

	public void setAddress(Address address) {
		
		this.address = address;
	}

	public List<Phone> getPhones() {
		
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		
		this.phones = phones;
	}

	public Date getDOB() {
		
		return DOB;
	}

	public void setDOB(Date dOB) {
		
		DOB = dOB;
	}

	public List<Account> getAccounts() {
		
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		
		this.accounts = accounts;
	}

	public boolean isCustomer() {
		return isCustomer;
	}

	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	} 
}
