package com.tamara.bankappli.model;

import com.tamara.bankappli.enums.PhoneType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone {
		 
	private PhoneType phoneType;
	
	@Id @GeneratedValue
	@Column(name = "id")  
	private Long ID;
	
	@OneToOne
    @JoinColumn(name = "country_code")
	@Column(name = "country_code")
	private short country_code;
	
	@Column(name = "area_code")
	private short area_code;
	
	@Column(name = "phone_number")
	private int phone_number;
	
	@Column(name = "phone_type")
	private PhoneType phone_type;
		
	public Long getID() {
		
		return ID;
	}
	
	public void setID(Long iD) {
		
		ID = iD;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public short getCountry_code() {
		
		return country_code;
	}

	public void setCountry_code(short country_code) {
		
		this.country_code = country_code;
	}

	public short getArea_code() {
		
		return area_code;
	}

	public void setArea_code(short area_code) {
		
		this.area_code = area_code;
	}

	public int getPhone_number() {
		
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
	
		this.phone_number = phone_number;
	}

	public PhoneType getPhone_type() {
		
		return phone_type;
	}

	public void setPhone_type(PhoneType phone_type) {
	
		this.phone_type = phone_type;
	}
}