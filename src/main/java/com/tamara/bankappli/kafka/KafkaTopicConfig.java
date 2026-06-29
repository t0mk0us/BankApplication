package com.tamara.bankappli.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createMySpringTopic() {
        return TopicBuilder.name("test-topic")
                .partitions(3)
                .replicas(1)
                .compact() // Optional: Enables log compaction policy if needed
                .build();
    }
}

