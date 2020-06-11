package com.booktheticket.moviems.exceptionhandling;

public class MovieWithSameNameLanguageFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieWithSameNameLanguageFoundException() {
		super();

	}

	public MovieWithSameNameLanguageFoundException(String message) {
		super(message);

	}
	
}
