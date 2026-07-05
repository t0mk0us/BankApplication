package com.tamara.bankappli.model;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
@Entity
@Table(name = "USER_ROLES")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;
	
	@Column(name = "userRole")  
	private String userRole;

	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}

	public UserRole(Long iD, String userRole) {
		super();
		ID = iD;
		this.userRole = userRole;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
}
