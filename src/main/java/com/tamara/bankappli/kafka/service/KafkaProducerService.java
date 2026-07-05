package com.tamara.bankappli.kafka.service;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tamara.bankappli.model.Account;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    // Spring automatically injects the pre-configured template
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Sent message: " + message);
    }
}

