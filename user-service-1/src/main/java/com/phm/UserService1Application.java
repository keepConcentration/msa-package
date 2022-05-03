package com.phm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserService1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserService1Application.class, args);
	}

}
