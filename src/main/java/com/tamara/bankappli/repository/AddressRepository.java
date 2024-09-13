package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Address;


@Repository
public interface AddressRepository
        extends JpaRepository<Address, UUID>, JpaSpecificationExecutor<Address> {

	List<Address> findByCustomer(UUID id);
		
}
