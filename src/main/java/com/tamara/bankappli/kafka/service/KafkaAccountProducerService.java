package com.tamara.bankappli.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tamara.bankappli.model.Account;

@Service
public class KafkaAccountProducerService {
	
	    private final KafkaTemplate<String, String> kafkaTemplate;

	    public KafkaAccountProducerService(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendAccount(String topic, String account) {
	        // Pass the object directly; Spring handles the conversion to JSON bytes
	        kafkaTemplate.send(topic, account);
	        System.out.println("Produced JSON event for user: " + account.toString());
	    }
}
