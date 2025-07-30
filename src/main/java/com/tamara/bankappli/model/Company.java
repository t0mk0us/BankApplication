package com.tamara.bankappli.model;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.CompanyType;
import com.tamara.bankappli.enums.Industry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "COMPANY_1")
public class Company {
	  
	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private Long ID;

	@Column(name = "company_name")  
	private String companyName;
	
	@Enumerated(EnumType.ORDINAL)	
	@Column(name = "company_type")
	private CompanyType company_type;	

	@Enumerated(EnumType.ORDINAL)
	@JoinColumn(name = "id")
	private Industry industry;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "contact_person")
	private Person contact_person;
	
	@OneToOne
	@JoinColumn(name = "contact_phone")
	private Phone contact_phone;
	
	public Company() {
		
	}
	
	public Company(String companyName, CompanyType company_type, Industry industry, Person contact_person,
			Phone contact_phone) {
		super();
		this.companyName = companyName;
		this.company_type = company_type;
		this.industry = industry;
		this.contact_person = contact_person;
		this.contact_phone = contact_phone;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public CompanyType getCompany_type() {
		return company_type;
	}

	public void setCompany_type(CompanyType company_type) {
		this.company_type = company_type;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Person getContact_person() {
		return contact_person;
	}

	public void setContact_person(Person contact_person) {
		this.contact_person = contact_person;
	}

	public Phone getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(Phone contact_phone) {
		this.contact_phone = contact_phone;
	}
}
