package com.booktheticket.bookingms.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ 
			BookingValidationException.class,BookingNotFound.class,ScreenNotFound.class,Exception.class })
	public ResponseEntity<ExceptionMessage> handleUserExceptions(Exception ex) {

		ExceptionMessage errorMessage = new ExceptionMessage();
		HttpStatus status;
		errorMessage.setLocalDateTime(LocalDateTime.now());
		
		if(ex instanceof ScreenNotFound || ex instanceof BookingNotFound) {
			errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
			errorMessage.setErrorMessage(HttpStatus.NOT_FOUND.toString());
			errorMessage.setErrorDescription(ex.getMessage());
			status = HttpStatus.NOT_FOUND;
			
		}else {
			errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
			errorMessage.setErrorMessage(HttpStatus.BAD_REQUEST.toString());
			errorMessage.setErrorDescription(ex.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}

		
		return new ResponseEntity<>(errorMessage, status);

	}

}
