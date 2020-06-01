package com.booktheticket.bookingms.domain.model;

public class SeatingoutDto {
	
	private String seatNumber;
	private boolean isBooked;
	
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public SeatingoutDto(String seatNumber, boolean isBooked) {
		super();
		this.seatNumber = seatNumber;
		this.isBooked = isBooked;
	}
	public SeatingoutDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
