package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.PersonRepository;
import com.tamara.bankappli.model.Person;
import com.tamara.bankappli.model.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class PersonService {

	private final PersonRepository personRepo;
	
    @Autowired
    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

	public List<Person> getAll() {
		
		log.info("Listing Customers");
		
		return personRepo.findAll();
	}
	
	public Person getByID(Long id) {	
		
		return personRepo.getReferenceById(id);	
	}
	
	public Person getByFirstAndLast(String fname, String lname) {
		
		return personRepo.findByFirstNameAndLastName(fname, lname);
		
	}
	
    public String savePerson(Person a) {
        Long newPrsId = personRepo.save(a).getID();
        return "New person was successfully saved with ID = " + newPrsId;	
    }
	
    public String deletePerson(Person a) {
        personRepo.delete(a);
        return "Person with ID was successfully deleted = " + a.getID();
    }
	
	public long countPersons() {
		
		return personRepo.count();
	}
}
