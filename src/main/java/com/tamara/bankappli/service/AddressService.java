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

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.model.Address;
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
	
	public List<Address> findByCustomerId(UUID id) {
		
		return addressRepo.findByCustomer(id);	
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
