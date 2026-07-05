package com.tamara.bankappli.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tamara.bankappli.repository.PhoneRepository;
import com.tamara.bankappli.enums.InvestmentType;
import com.tamara.bankappli.enums.PhoneType;
import com.tamara.bankappli.model.Investment;
import com.tamara.bankappli.model.Phone;
import lombok.extern.slf4j.Slf4j;

@Service // Cleaned up: Removed duplicate @Component annotation
@Slf4j
public class PhoneService {
	
    private final PhoneRepository phoneRepo;
	
    public PhoneService(PhoneRepository phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    public List<Phone> getAll() {
        log.info("Listing Phones");
        return phoneRepo.findAll();
    }
	
    public Phone getByID(Long id) {
        return phoneRepo.getReferenceById(id);	
    }
    
    public List<Phone> getByType(Long type) {
    	PhoneType invstType = PhoneType.getById(type);
        return phoneRepo.findByPhoneType(invstType);	
    }

    public String savePhone(Phone a) {
        Long newAccId = phoneRepo.save(a).getID();
        return "New phone was successfully saved with ID = " + newAccId;	
    }
	
    public String deletePhone(Phone a) {
        phoneRepo.delete(a);
        return "Phone with ID was successfully deleted = " + a.getID();
    }
	
    public Long countPhones() {
        return phoneRepo.count();
    }
}
