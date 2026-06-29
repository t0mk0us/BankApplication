package com.tamara.bankappli.model;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "BANK_USERS")
public class BankUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long ID;
	
	@Column(name = "userName")  
	private String userName;
	
	@Column(name = "password")
	private String password;
	
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "userRole", nullable = false)
    private Set<String> userRoles;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public Set<String> getUserRoles() { return userRoles; }
    public void setUserRoles(Set<String> roles) { this.userRoles = roles; }
}
