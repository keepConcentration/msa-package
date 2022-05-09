package com.phm.kafka.producer;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

	private KafkaProducer<String, String> producer = null;
	
	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value(value = "${spring.kafka.producer.key-serializer}")
	private String keySerializer;
	
	@Value(value = "${spring.kafka.producer.value-serializer}")
	private String valueSerializer;
	
	// 해당 서비스에서 발행 및 메세지 소비를 위한 테스트 토픽
	// TODO board로 변경
	private String topic = "user";
	
	@PostConstruct
	public void build() {
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
		
		producer =  new KafkaProducer<>(properties);
	}
	
	public void sendMessage(String message) {
		ProducerRecord<String, String> prd = new ProducerRecord<>(this.topic, message);
		producer.send(prd);
		
	}
}
