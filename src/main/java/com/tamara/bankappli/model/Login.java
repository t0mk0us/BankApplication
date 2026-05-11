package com.tamara.bankappli.model;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "LOGIN")
public class Login {

	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long ID;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "success")
	private boolean isSuccessful;
	
	public Login() {
		
	}

	public Login(String user, String password, boolean isSuccessful) {
		super();
		this.user = user;
		this.password = password;
		this.isSuccessful = isSuccessful;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
}

