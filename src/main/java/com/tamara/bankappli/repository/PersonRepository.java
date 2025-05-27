package com.tamara.bankappli.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Customer;
import com.tamara.bankappli.model.Person;

@Component
@Repository
public interface PersonRepository 
	extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person>{
	
		public Person findByFirstNameAndLastName(String firstName, String lastName);

}
