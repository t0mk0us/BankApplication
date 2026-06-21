package com.tamara.bankappli.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerWithResources {

	    public static void main(String[] args) {
	        // 1. Define producer configuration
	        Properties props = new Properties();
	        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

	        // 2. Try-with-resources automatically closes the producer
	        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
	            
	            ProducerRecord<String, String> record = 
	                new ProducerRecord<>("my-topic", "my-key", "Hey, Kafka! Hello from Tomkous!");

	            // Asynchronous Send with Callback
	            producer.send(record, (RecordMetadata metadata, Exception exception) -> {
	                if (exception != null) {
	                    System.err.println("Async send failed: " + exception.getMessage());
	                } else {
	                    System.out.printf("Message sent to topic %s [partition %d] at offset %d%n",
	                            metadata.topic(), metadata.partition(), metadata.offset());
	                }
	            });

	            // Optional: Synchronous Send (blocks the thread)
	            // Future<RecordMetadata> future = producer.send(record);
	            // RecordMetadata metadata = future.get(); 

	        } catch (Exception e) {
	            // Handles initialization failures, synchronous get() errors, or runtime issues
	            System.err.println("An error occurred in the Kafka Producer: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
