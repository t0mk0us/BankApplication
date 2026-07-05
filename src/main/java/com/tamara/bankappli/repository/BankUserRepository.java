package com.tamara.bankappli.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.BankUser;


//	@Component
//	@Repository
	public interface BankUserRepository
		extends JpaRepository<BankUser, Long>{
			
		Optional<BankUser> findByUserNameAndPassword(String name, String password);
			
			//Optional<List<BankUser>> List<BankUser> findByUserRole(String role);

		Optional<BankUser> findByUserName(String name);
	}

