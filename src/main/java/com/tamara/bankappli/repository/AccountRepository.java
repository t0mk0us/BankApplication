package com.tamara.bankappli.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Customer;

import jakarta.persistence.EntityManager;


@Repository
public interface AccountRepository
        extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
	
	public List<Account> findByOwner(Customer owner);
	
	public List<Account> findByOwnerID(Long id);
	
}
