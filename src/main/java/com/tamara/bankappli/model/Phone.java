package com.tamara.bankappli.model;

import java.io.Serializable;
import java.util.UUID;

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
	private UUID ID;
	
	//@ManyToOne
    @Column(name = "country_code")
	private Short country_code;
	
	@Column(name = "area_code")
	private Short area_code;
	
	@Column(name = "phone_number")
	private Integer phone_number;
	
	//@ManyToOne
	/*
	 * @Enumerated(EnumType.STRING)
	 * 
	 * @JdbcTypeCode(SqlTypes.JSON)
	 * 
	 * @JoinColumn(name = "phone_type")
	 */
	//private PhoneType phone_type;
		
	public UUID getID() {
		
		return ID;
	}
	
	public void setID(UUID iD) {
		
		ID = iD;
	}

	/*
	 * public PhoneType getPhoneType() { return phone_type; }
	 * 
	 * public void setPhoneType(PhoneType phoneType) { this.phone_type = phoneType;
	 * }
	 */

	public Short getCountry_code() {
		
		return country_code;
	}

	public void setCountry_code(Short country_code) {
		
		this.country_code = country_code;
	}

	public Short getArea_code() {
		
		return area_code;
	}

	public void setArea_code(Short area_code) {
		
		this.area_code = area_code;
	}

	public Integer getPhone_number() {
		
		return phone_number;
	}

	public void setPhone_number(Integer phone_number) {
	
		this.phone_number = phone_number;
	}
}