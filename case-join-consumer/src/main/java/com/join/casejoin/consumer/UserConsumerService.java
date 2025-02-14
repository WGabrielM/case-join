package com.join.casejoin.consumer;

import com.join.casejoin.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(UserConsumerService.class);

    @KafkaListener(
        topics = "user-registration",
        groupId = "user-registration-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(User user) {
        try {
            logger.info("Received user registration: {}", user);
            // Add your business logic here
        } catch (Exception e) {
            logger.error("Error processing user registration: {}", e.getMessage());
        }
    }
} 