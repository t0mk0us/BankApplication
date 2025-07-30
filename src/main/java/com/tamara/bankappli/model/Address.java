package com.tamara.bankappli.model;

import java.util.UUID;

import java.lang.annotation.Annotation;
import org.hibernate.id.factory.internal.UUIDGenerationTypeStrategy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long ID;
	
	//private String name; 

	@Column(name = "number")
	private String number;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "appartment")
	private String appartment;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state_province")
	private String state_province;
	
	@OneToOne
	@JoinColumn(name = "country_id")
	//Aggregation
	//Country exists independently of an account
	//Country will still exist, even a particular Address disappears
	private Country countryId;
	
	@Column(name = "postal_Code")
	private String postalCode;
	
	public Address() {
		
	}
	
	public Address(String number, String street, String appartment, String city, String state_province,
			Country countryId, String postalCode) {
		super();
		this.number = number;
		this.street = street;
		this.appartment = appartment;
		this.city = city;
		this.state_province = state_province;
		this.countryId = countryId;
		this.postalCode = postalCode;
	}

	public Country getCountryId() {
		return countryId;
	}
	
	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAppartment() {
		return appartment;
	}
	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public Country getCountry() {
		return countryId;
	}
	public void setCountry(Country country) {
		this.countryId = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
}
