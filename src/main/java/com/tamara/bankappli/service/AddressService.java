package com.tamara.bankappli.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.model.Person;
import com.tamara.bankappli.repository.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class AddressService {

	@Autowired
	AddressRepository addressRepo;
	
	public List<Address> getAll() {
		
		log.info("Listing Addresses");
		
		return addressRepo.findAll();
	}
	
	public Address getByID(UUID id) {
		
		return addressRepo.getReferenceById(id);	
	}
	
	public List<Address> findByPerson(Person p) {
		
		return findByPersonId(p.getID());
	}
	
	private List<Address> findByPersonId(UUID id) {

		return addressRepo.findByPersonID(id);
	}
	
	public Address saveAddress(Address a) {
		
		return addressRepo.save(a);	
	}
	
	public void deleteAddress(Address a) {
		
		addressRepo.delete(a);
		
		return;
	}
	
	public long countAddress() {
		
		return addressRepo.count();
	}
}
