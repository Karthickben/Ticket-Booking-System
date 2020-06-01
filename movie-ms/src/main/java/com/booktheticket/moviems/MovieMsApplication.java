package com.booktheticket.moviems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.booktheticket.*"})
@EnableJpaRepositories("com.booktheticket.*")
public class MovieMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMsApplication.class, args);
	}

}
