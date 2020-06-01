package com.booktheticket.userms.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {
	
	
	
	@ExceptionHandler(value = { UserNotFoundException.class,Exception.class,RuntimeException.class,
			UserValidationError.class})
	public ResponseEntity<ExceptionMessage> handleUserExceptions(Exception ex) {
		
		ExceptionMessage errorMessage = new ExceptionMessage();
		HttpStatus status;
		errorMessage.setLocalDateTime(LocalDateTime.now());
		if(ex instanceof UserNotFoundException) {
				errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
			   errorMessage.setErrorMessage(HttpStatus.NOT_FOUND.toString());
			   errorMessage.setErrorDescription(ex.getMessage());
			   status=HttpStatus.NOT_FOUND;
			 
		}else if(ex instanceof RuntimeException){
			
			DataAccessException exception = (DataAccessException) ex;
			
			System.out.println(exception);
			
			errorMessage.setErrorDescription(exception.getMostSpecificCause().getMessage());
			errorMessage.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			   errorMessage.setErrorMessage(HttpStatus.NOT_ACCEPTABLE.toString());
			   status=HttpStatus.NOT_ACCEPTABLE;
			
		}else {
			 	errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
			   errorMessage.setErrorMessage(HttpStatus.BAD_REQUEST.toString());
			   errorMessage.setErrorDescription(ex.getMessage());
			   status=HttpStatus.BAD_REQUEST;
			   
		}
		
		
		return new ResponseEntity<ExceptionMessage>(errorMessage, status);
		
		
	}
		

}
