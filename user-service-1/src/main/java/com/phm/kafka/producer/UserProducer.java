package com.phm.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

	private static final String TOPIC = "user";
	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public UserProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		System.out.println(String.format("Produce message : %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}
}
