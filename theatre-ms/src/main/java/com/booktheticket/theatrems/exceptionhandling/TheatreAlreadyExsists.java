package com.booktheticket.theatrems.exceptionhandling;



public class TheatreAlreadyExsists extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TheatreAlreadyExsists() {
		super();
		
	}

	public TheatreAlreadyExsists(String message) {
		super(message);
		
	}
	
	

}
