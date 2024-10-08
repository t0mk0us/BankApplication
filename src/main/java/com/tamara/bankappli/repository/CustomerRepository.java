package com.tamara.bankappli.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Customer;

@Repository
public interface CustomerRepository 
	extends JpaRepository<Customer, UUID>, JpaSpecificationExecutor<Customer>{
	
		public Customer findByFirstNameAndLastName(String firstName, String lastName);

}
