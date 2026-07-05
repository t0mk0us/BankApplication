package com.tamara.bankappli.kafka.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tamara.bankappli.model.Account;

@Service
public class KafkaAccountConsumerService {

	    @KafkaListener(topics = "test-topic", groupId = "json-group")
	    public void consume(Account account) {
	        // You can read properties natively without manual ObjectMapper parsing
	        System.out.printf("Consumed JSON -> Account: %s, Action: %s%n", 
	        		account.getID(), account.toString());
	    }
}
