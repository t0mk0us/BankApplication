package com.tamara.bankappli.model;

import java.util.Date;

public class Person extends Customer{
	
	  enum Sex {
		    FEMALE,
		    MALE;		  
		  }
	  
	private String firstName;
	private String lastName;
	private String placeOfWork;
	private Date DOB;
	private Sex sex;
	
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
	public String getPlaceOfWork() {
		return placeOfWork;
	}
	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}	
}
