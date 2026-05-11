package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tamara.bankappli.repository.AddressRepository;
import com.tamara.bankappli.repository.LoginRepository;
import com.tamara.bankappli.repository.UserRepository;
import com.tamara.bankappli.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class LoginService {
		
	//private final LoginRepository loginRepo;
	
	private final UserRepository userRepo;
		
	public LoginService(UserRepository repo) {
	        this.userRepo = repo;
	  	}

	public boolean checkCredentials(String userName, String userPass) {
	    	
    	User u;
    	
    	u = userRepo.findByNameAndPassword(userName, userPass);
    	
    	if (u != null) {
    		
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
