package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.model.Person;

@Component
@Repository
public interface AddressRepository
        extends JpaRepository<Address, UUID>, JpaSpecificationExecutor<Address> {

	List<Address> findByPerson(Person p);
	
	public List<Address> findByPersonID(UUID id);
		
}
