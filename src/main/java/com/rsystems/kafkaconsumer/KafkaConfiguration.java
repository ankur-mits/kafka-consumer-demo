package com.rsystems.kafkaconsumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	 @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
	 
	    @Bean
	    public ConsumerFactory<String, String> consumerFactory() {
	        Map<String, Object> config = new HashMap<>();

	        //config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.67.171.30:9092");
	        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "203.34.117.152:9092");
	        config.put(ConsumerConfig.GROUP_ID_CONFIG, "1");
	        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	        return new DefaultKafkaConsumerFactory<>(config);
	    }
}
