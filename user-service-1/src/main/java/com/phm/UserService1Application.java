package com.phm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.phm.kafka.consumer.UserConsumer;
import com.phm.kafka.producer.UserProducer;

@EnableEurekaClient
@SpringBootApplication
public class UserService1Application implements CommandLineRunner {
	
	@Autowired
	private UserProducer userProducer;
	
	@Autowired
	private UserConsumer userConsumer;

	public static void main(String[] args) {
		SpringApplication.run(UserService1Application.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		userProducer.sendMessage("USER PRODUCER MESSAGE SEND.");
	}
}
