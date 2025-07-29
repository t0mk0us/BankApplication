package com.tamara.bankappli.model;

import java.io.Serializable;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.stereotype.Component;

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

@Component
@Entity
@Table(name = "PHONE")
public class Phone  implements Serializable {
		 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")  
	private Long ID;
	
	//@ManyToOne
    @Column(name = "country_code_id")
	private Long country_code;
	
	@Column(name = "area_code_id")
	private Long area_code;
	
	@Column(name = "phone_number")
	private Integer phone_number;
	
	@Column(name = "phone_type")
	private short phone_type;
	
	//@ManyToOne
	/*
	 * @Enumerated(EnumType.STRING)
	 * 
	 * @JdbcTypeCode(SqlTypes.JSON)
	 * 
	 * @JoinColumn(name = "phone_type")
	 */
	//private PhoneType phone_type;
	
	public Phone() {
		
	}
	
	public Phone(Long country_code, Long area_code, Integer phone_number, short phone_type) {
		super();
		this.country_code = country_code;
		this.area_code = area_code;
		this.phone_number = phone_number;
		this.phone_type = phone_type;
	}
	
	public Long getID() {
		
		return ID;
	}

	public void setID(Long iD) {
		
		ID = iD;
	}

	/*
	 * public PhoneType getPhoneType() { return phone_type; }
	 * 
	 * public void setPhoneType(PhoneType phoneType) { this.phone_type = phoneType;
	 * }
	 */

	public Long getCountry_code() {
		
		return country_code;
	}

	public void setCountry_code(Long country_code) {
		
		this.country_code = country_code;
	}

	public Long getArea_code() {
		
		return area_code;
	}

	public void setArea_code(Long area_code) {
		
		this.area_code = area_code;
	}

	public Integer getPhone_number() {
		
		return phone_number;
	}

	public void setPhone_number(Integer phone_number) {
	
		this.phone_number = phone_number;
	}

	public short getPhone_type() {
		return phone_type;
	}

	public void setPhone_type(short phone_type) {
		this.phone_type = phone_type;
	}
	
	
}