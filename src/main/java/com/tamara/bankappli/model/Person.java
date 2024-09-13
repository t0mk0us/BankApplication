package com.tamara.bankappli.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tamara.bankappli.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person extends Customer{
		
	@Column(name = "first_name")  
	private String firstName;
		
	@Column(name = "last_name")
	private String lastName;
		
	@Column(name = "gender")
	private Gender gender;
		
	@Column(name = "place_of_work")
	private String placeOfWork;
		
	@OneToOne
	@JoinColumn(name = "address")
	private Address address;
		
	@OneToMany
	@JoinColumn(name = "phone_id")
	private List<Phone> phones;
		
	@Column(name = "date_of_birth")
	private Date DOB;
		
	@OneToMany
	@JoinColumn(name = "account")
	private List<Account> accounts;

	public UUID getID() {
		
		return super.getID();
	}

	public void setID(UUID iD) {
		
		super.setID(iD);
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
}
