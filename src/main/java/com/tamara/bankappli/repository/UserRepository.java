package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.User;

	@Component
	@Repository
	public interface UserRepository
		extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
		
			public User findByName(String name);
			
			public User findByNameAndPassword(String name, String password);
			
			public List<User> findByRole(String role);

	}

