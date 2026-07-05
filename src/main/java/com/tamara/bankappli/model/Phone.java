package com.tamara.bankappli.model;

import java.io.Serializable;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tamara.bankappli.enums.InvestmentType;
import com.tamara.bankappli.enums.PhoneType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "PHONE")
public class Phone  implements Serializable {
		 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")  
	private Long ID;
	
	//@ManyToOne
    @Column(name = "country_code")
	private short country_code;
	
	@Column(name = "area_code")
	private int area_code;
	
	@Column(name = "phone_number")
	private Integer phone_number;
	
    @Enumerated(EnumType.ORDINAL)
	@Column(name = "phone_type")
	private PhoneType phoneType;
	
	public Phone() {
		
	}
	
	public Phone(short country_code, int area_code, Integer phone_number, PhoneType phone_type) {
		super();
		this.country_code = country_code;
		this.area_code = area_code;
		this.phone_number = phone_number;
		this.phoneType = phone_type;
	}
	
	public Long getID() {
		
		return ID;
	}

	public void setID(Long iD) {
		
		ID = iD;
	}

	public short getCountry_code() {
		
		return country_code;
	}

	public void setCountry_code(short country_code) {
		
		this.country_code = country_code;
	}

	public int getArea_code() {
		
		return area_code;
	}

	public void setArea_code(int area_code) {
		
		this.area_code = area_code;
	}

	public Integer getPhone_number() {
		
		return phone_number;
	}

	public void setPhone_number(Integer phone_number) {
	
		this.phone_number = phone_number;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phone_type) {
		this.phoneType = phone_type;
	}	
}