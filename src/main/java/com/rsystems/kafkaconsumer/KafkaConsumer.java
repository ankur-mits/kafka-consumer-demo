package com.rsystems.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	@KafkaListener(topics = "ten_topic", group = "1")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
