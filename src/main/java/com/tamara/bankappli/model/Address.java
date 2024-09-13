package com.tamara.bankappli.model;

import java.util.UUID;

import java.lang.annotation.Annotation;
import org.hibernate.id.factory.internal.UUIDGenerationTypeStrategy;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {


	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private UUID ID;
	
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
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postal_Code")
	private String postalCode;
	
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
}
