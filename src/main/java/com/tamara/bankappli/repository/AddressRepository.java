package com.tamara.bankappli.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Address;


@Repository
public interface AddressRepository
        extends JpaRepository<Address, String>, JpaSpecificationExecutor<Address> {
	
	
}
