package com.booktheticket.moviems.exceptionhandling;

import java.time.LocalDateTime;

public class ExceptionMessage {
	
	private int errorSatatus;
	private String errorMessage;
	private String errorDescription;
	private LocalDateTime localDateTime;
	
	
	public int getErrorSatatus() {
		return errorSatatus;
	}
	public void setErrorSatatus(int errorSatatus) {
		this.errorSatatus = errorSatatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	
}
