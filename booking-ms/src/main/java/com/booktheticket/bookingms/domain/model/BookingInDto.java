package com.booktheticket.bookingms.domain.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookingInDto {
	
	
	@Email @NotNull @NotEmpty
	private String userId;
	@Min(1)
	private int theatreId;
	@Min(1)
	private int movieId;
	@Min(1)
	private int screenId;
	@NotEmpty @NotNull
	private String showDate;
	@Min(1)
	private int showId;
	@Min(1)
	private int showTimeId;
	@NotEmpty @NotNull
	private String showTime;
	@Min(1)
	private double ticketPrice;
	@NotEmpty @NotNull
	private String seatNumbers;
	@Min(1)
	private int numberOfSeatsBooked;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
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
	public int getNumberOfSeatsBooked() {
		return numberOfSeatsBooked;
	}
	public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
		this.numberOfSeatsBooked = numberOfSeatsBooked;
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
	public int getShowTimeId() {
		return showTimeId;
	}
	public void setShowTimeId(int showTimeId) {
		this.showTimeId = showTimeId;
	}
	@Override
	public String toString() {
		return "BookingInDto [userId=" + userId + ", theatreId=" + theatreId + ", movieId=" + movieId + ", screenId="
				+ screenId + ", showDate=" + showDate + ", showId=" + showId + ", showTimeId=" + showTimeId
				+ ", showTime=" + showTime + ", ticketPrice=" + ticketPrice + ", seatNumbers=" + seatNumbers
				+ ", numberOfSeatsBooked=" + numberOfSeatsBooked + "]";
	}
	
	
	
	
}
