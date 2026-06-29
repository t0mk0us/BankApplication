package com.tamara.bankappli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.BankUserRepository;
import com.tamara.bankappli.model.BankUser;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class BankUserService {

	private final BankUserRepository userRepo;
	
    @Autowired
    public BankUserService(BankUserRepository userRepo) {
        this.userRepo = userRepo;
    }

	public List<BankUser> getAll() {
		
		log.info("Listing Users");
		
		return userRepo.findAll();
	}
	
	public BankUser getByID(Long id) {	
		
		return userRepo.getReferenceById(id);	
	}
	
	public Optional<BankUser> getByUserName(String userName) {
		
		return userRepo.findByUserName(userName);
		
	}
		
		public BankUser saveUser(BankUser p) {
			
			return userRepo.save(p);
		}
		
		public void deletePerson(BankUser p) {
			
			userRepo.delete(p);
			
			return;
		}
		
		public long countUsers() {
			
			return userRepo.count();
		}
	}
