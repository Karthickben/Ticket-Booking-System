package com.booktheticket.moviems.exceptionhandling;

public class MovieNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException() {
		super();

	}

	public MovieNotFoundException(String message) {
		super(message);

	}
	
}
