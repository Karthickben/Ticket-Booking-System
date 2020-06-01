package com.booktheticket.theatrems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.booktheticket.*"})
@EnableJpaRepositories(basePackages = {"com.booktheticket.*"})
@EnableCircuitBreaker
public class TheatreMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreMsApplication.class, args);
	}

}
