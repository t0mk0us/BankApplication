package com.tamara.bankappli.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.repository.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressService {

	@Autowired
	AddressRepository addressRepo;
	
	public List<Address> getAll() {
		
		log.info("Listing ddresses");
		
		return addressRepo.findAll();
	}

}
