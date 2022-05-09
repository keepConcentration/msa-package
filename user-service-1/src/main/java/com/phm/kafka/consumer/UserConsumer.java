package com.phm.kafka.consumer;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

	private KafkaConsumer<String, String> consumer = null;
	
	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value(value = "${spring.kafka.consumer.key-deserializer}")
	private String keyDeserializer;
	
	@Value(value = "${spring.kafka.consumer.value-deserializer}")
	private String valueDeserializer;
	
	private String topic = "user";
	
	@PostConstruct
	public void build() {
		Properties properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
		
		consumer = new KafkaConsumer<>(properties);
	}
	
	@KafkaListener(topics = "user")
	public void consume(@Headers MessageHeaders headers, @Payload String payload) {
		System.out.println("CONSUME HEADERS : " + headers.toString());
		System.out.println("CONSUME PAYLOAD : " + payload);
	}
	
}
