package com.demo_microservices.demo_rider_service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoRiderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRiderServiceApplication.class, args);
	}

}