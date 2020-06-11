package com.booktheticket.bookingms;

import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.booktheticket.bookingms.domain.model.ApiStatus;

@Configuration
public class BookingConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return  new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(2000))
		        .setReadTimeout(Duration.ofMillis(2000))
		        .build();
	}

	@Bean
	public ApiStatus apiStatus() {
		return new ApiStatus();
	}

}
