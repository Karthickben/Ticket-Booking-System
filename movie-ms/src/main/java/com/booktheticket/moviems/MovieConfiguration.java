package com.booktheticket.moviems;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booktheticket.moviems.domain.model.ApiStatus;

@Configuration
public class MovieConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}
	
	@Bean
	public ApiStatus apiStatus() {
		return new ApiStatus();
	}

}
