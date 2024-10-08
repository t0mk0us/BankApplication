package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Account;


@Repository
public interface AccountRepository
        extends JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account> {
	
	public List<Account> findByCustomer(UUID id);
	
}
