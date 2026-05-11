package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.UserRepository;
import com.tamara.bankappli.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class UserService {

	private final UserRepository userRepo;
	
    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

	public List<User> getAll() {
		
		log.info("Listing Users");
		
		return userRepo.findAll();
	}
	
	public User getByID(Long id) {	
		
		return userRepo.getReferenceById(id);	
	}
	
	public User getByUserName(String userName) {
		
		return userRepo.findByName(userName);
		
	}
		
		public User saveUser(User p) {
			
			return userRepo.save(p);
		}
		
		public void deletePerson(User p) {
			
			userRepo.delete(p);
			
			return;
		}
		
		public long countUsers() {
			
			return userRepo.count();
		}
	}
