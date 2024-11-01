package com.tamara.bankappli.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.repository.PersonRepository;
import com.tamara.bankappli.model.Customer;
import com.tamara.bankappli.model.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class PersonService {

	@Autowired
	PersonRepository personRepo;

	public List<Person> getAll() {
		
		log.info("Listing Customers");
		
		return personRepo.findAll();
	}
	
	public Person getByID(UUID id) {	
		
		return personRepo.getReferenceById(id);	
	}
	
	public Person saveCustomer(Person p) {
		
		return personRepo.save(p);
	}
	
	public void deletePerson(Person p) {
		
		personRepo.delete(p);
		
		return;
	}
	
	public long countPersons() {
		
		return personRepo.count();
	}
}
