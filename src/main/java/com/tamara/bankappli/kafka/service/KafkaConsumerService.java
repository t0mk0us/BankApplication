package com.tamara.bankappli.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "quickstart", groupId = "my-boot-group")
    public void listen(String message) {
        System.out.println("Received message in Spring Boot: " + message);
    }
}
