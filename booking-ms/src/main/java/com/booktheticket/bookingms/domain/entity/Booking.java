package com.booktheticket.bookingms.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="Booking")
@Entity(name="booking")
public class Booking {
	
	@Id
	@SequenceGenerator(name="bid",initialValue = 7000001,allocationSize = 1)
	@GeneratedValue(generator = "bid",strategy = GenerationType.SEQUENCE)
	@Column(name="Booking_Id")
	private int bookingId;
	@Column(name="User_Id",nullable = false)
	private String userId;
	@Column(name="Theatre_Id",nullable =false)
	private int theatreId;
	@Column(name="Movie_Id",nullable =false)
	private int movieId;
	@Column(name="Screen_Id",nullable =false)
	private int screenId;
	@Column(name="Show_Time_Id",nullable =false)
	private int showTimeId;
	@Column(name="Show_date",nullable =false)
	private LocalDate showDate;
	@Column(name="Show_Time",nullable =false)
	private LocalTime showTime;
	@Column(name="Ticket_Price",nullable =false)
	private double ticketPrice;
	@Column(name="Total_Price",nullable =false)
	private double totalPrice;
	@Column(name="Number_Of_Seats_Booked",nullable =false)
	private int numberOfSeatsBooked;
	@Column(name="Seat_Numbers",nullable = false)
	private String seatNumbers;
	@Column(name="Last_Updated_Timestamp",nullable = false)
	private LocalDateTime lastUpdatedTimestamp;
	@Column(name="Ticket_Staus")
	private String ticketStatus;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
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
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getNumberOfSeatsBooked() {
		return numberOfSeatsBooked;
	}
	public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
		this.numberOfSeatsBooked = numberOfSeatsBooked;
	}
	public String getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public int getShowTimeId() {
		return showTimeId;
	}
	public void setShowTimeId(int showTimeId) {
		this.showTimeId = showTimeId;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", theatreId=" + theatreId + ", movieId="
				+ movieId + ", screenId=" + screenId + ", showTimeId=" + showTimeId + ", showDate=" + showDate
				+ ", showTime=" + showTime + ", ticketPrice=" + ticketPrice + ", totalPrice=" + totalPrice
				+ ", numberOfSeatsBooked=" + numberOfSeatsBooked + ", seatNumbers=" + seatNumbers
				+ ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + ", ticketStatus=" + ticketStatus + "]";
	}
	
	

}
