package com.example.EligibilityDeterminationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EligibilityDeterminationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EligibilityDeterminationServiceApplication.class, args);
	}

}
