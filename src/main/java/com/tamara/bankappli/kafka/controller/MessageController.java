package com.tamara.bankappli.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.bankappli.controller.AccountController;
import com.tamara.bankappli.kafka.service.KafkaAccountProducerService;
import com.tamara.bankappli.kafka.service.KafkaProducerService;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MessageController {
	
	@Autowired
	AccountRepository accountRepository;

    private final KafkaProducerService producerService;
    private final KafkaAccountProducerService accountProducerService;

    public MessageController(KafkaProducerService producerService, KafkaAccountProducerService accountProducerService) {
        this.producerService = producerService;
        this.accountProducerService = accountProducerService;
    }

    @GetMapping("/send")
    public String send(@RequestParam("msg") String message) {
        producerService.sendMessage("test-topic", message);
        return "Message queued: " + message;
    }
    
    @GetMapping("/sendaccounts")
    public String SendAccountsList() {
    	
		log.info("Lister tous les comptes existantes dans la table ACCOUNT");
    	
    	List<Account> allAccounts;
    	//allAccounts = accountService.getAll();
    	allAccounts = accountRepository.findAll();
    	
    	for(Account a : allAccounts) {
    		accountProducerService.sendAccount("test-topic", a.toString());
    	}
    	
    	return "List of Accounts sent";
    }
}