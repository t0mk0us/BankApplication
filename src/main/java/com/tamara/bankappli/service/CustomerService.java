package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.CustomerRepository;
import com.tamara.bankappli.model.Customer;
import com.tamara.bankappli.model.Customer;
import lombok.extern.slf4j.Slf4j;

@Service // Cleaned up: Removed duplicate @Component annotation
@Slf4j
public class CustomerService {
	
    private final CustomerRepository customerRepo;
	
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAll() {
        log.info("Listing Customers");
        return customerRepo.findAll();
    }
	
    public Customer getByID(Long id) {
        return customerRepo.getReferenceById(id);	
    }
	
    public Long countCustomers() {
        return customerRepo.count();
    }
	
	public String saveCustomer(Customer c) {
		
		Long newCurrId = customerRepo.save(c).getID();
		
		return "New customer was successfully saved with ID = " + newCurrId;		
	}
	
	public String deleteCustomer(Customer c) {
		
		customerRepo.delete(c);
		
		return "Customer with ID was successfully deleted = " + c.getID();
	}
}
