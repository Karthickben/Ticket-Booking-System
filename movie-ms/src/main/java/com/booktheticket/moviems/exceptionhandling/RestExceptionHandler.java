package com.booktheticket.moviems.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler(value = {MovieNotFoundException.class,BeanValidationException.class,Exception.class})
	public ResponseEntity<ExceptionMessage> handleMovieExceptions(Exception ex){
		
		ExceptionMessage errorMessage = new ExceptionMessage();
		errorMessage.setErrorDescription(ex.getMessage());
		errorMessage.setLocalDateTime(LocalDateTime.now());
		if(ex instanceof MovieNotFoundException) {
				errorMessage.setErrorSatatus(HttpStatus.NOT_FOUND.value());
			   errorMessage.setErrorMessage(HttpStatus.NOT_FOUND.toString());
			 
		}else {
			 	errorMessage.setErrorSatatus(HttpStatus.BAD_REQUEST.value());
			   errorMessage.setErrorMessage(HttpStatus.BAD_REQUEST.toString());
			   
		}
		
		return ResponseEntity.ok(errorMessage);
		
	}

}
