package com.booktheticket.bookingms.domain.model;

public class TicketDto {
	
	private String userEmailId;
	private String theatreName;
	private String screenName;
	private int bookingId;
	private String movieName;
	private String theatrAddress;
	private String showDate;
	private String showTime;
	private double ticketPrice;
	private String seatNumbers;
	private int totalSeatsBoooked;
	private double totalPrice;
	private String status;
	
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getTheatrAddress() {
		return theatrAddress;
	}
	public void setTheatrAddress(String theatrAddress) {
		this.theatrAddress = theatrAddress;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	public int getTotalSeatsBoooked() {
		return totalSeatsBoooked;
	}
	public void setTotalSeatsBoooked(int totalSeatsBoooked) {
		this.totalSeatsBoooked = totalSeatsBoooked;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	@Override
	public String toString() {
		return "TicketDto [userEmailId=" + userEmailId + ", theatreName=" + theatreName + ", screenName=" + screenName
				+ ", bookingId=" + bookingId + ", movieName=" + movieName + ", theatrAddress=" + theatrAddress
				+ ", showDate=" + showDate + ", showTime=" + showTime + ", ticketPrice=" + ticketPrice
				+ ", seatNumbers=" + seatNumbers + ", totalSeatsBoooked=" + totalSeatsBoooked + ", totalPrice="
				+ totalPrice + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
