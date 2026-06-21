package com.tamara.bankappli.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        // 1. Configure the producer connection properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 2. Initialize the producer
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            // 3. Create a record to send to your "quickstart" topic
            ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "key-1", "Hello from Java!");

            // 4. Send the data asynchronously
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Message sent successfully! Partition: " + metadata.partition());
                } else {
                    exception.printStackTrace();
                }
            });
        } // The try-with-resources statement automatically flushes and closes the producer
    }
}
