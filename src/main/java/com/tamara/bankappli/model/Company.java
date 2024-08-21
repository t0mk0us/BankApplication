package com.tamara.bankappli.model;

import com.tamara.bankappli.enums.CompanyType;
import com.tamara.bankappli.enums.Industry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company extends Customer{
	  
	@Id @GeneratedValue
	@Column(name = "id")  
	private Long ID;
		
	@Column(name = "company_name")  
	private String companyName;
		
	@Column(name = "company_type")
	private CompanyType company_type;	
	
	@Column(name = "industry")
	private  Industry industry;
				
	@Column(name = "contact_person")
	private String contact_person;
		
	@Column(name = "contact_phone")
	private Phone contact_phone;

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
	
	public int getCompany_typeId() {
		return company_type.ordinal();
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public Phone getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(Phone contact_phone) {
		this.contact_phone = contact_phone;
	}
}
