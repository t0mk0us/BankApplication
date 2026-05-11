package com.tamara.bankappli.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Customer;
import com.tamara.bankappli.model.Person;
import com.tamara.bankappli.model.User;

@Component
@Repository
public interface LoginRepository 
	extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
	
		public User findByName(String userName);
		
		public User findByNameAndPassword(String name, String pass);

		public List<User> findByRole(String userRole);
}


