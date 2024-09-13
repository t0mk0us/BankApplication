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

import com.tamara.bankappli.repository.CustomerRepository;
import com.tamara.bankappli.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public List<Customer> getAll() {
		
		log.info("Listing Customers");
		
		return customerRepo.findAll();
	}
	
	public Customer getByID(UUID id) {	
		
		return customerRepo.getReferenceById(id);	
	}
	
	public Customer saveCustomer(Customer c) {
		
		return customerRepo.save(c);
	}
	
	public void deletecustomerRepo(Customer c) {
		
		customerRepo.delete(c);
		
		return;
	}
	
	public long countCustomers() {
		
		return customerRepo.count();
	}
}
