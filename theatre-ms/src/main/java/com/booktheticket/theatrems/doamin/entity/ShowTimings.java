package com.booktheticket.theatrems.doamin.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="showTimings")
@Table(name="Show_Timings")
public class ShowTimings {
	
	@Id
	@SequenceGenerator(name = "stid",initialValue =1,allocationSize = 1)
	@GeneratedValue(generator = "stid",strategy = GenerationType.SEQUENCE)
	@Column(name="Show_Time_Id",length = 20)
	private int showTimeId;
	@ManyToOne
	@JoinColumn(name="Show_Id")
	private Show show;
	@Column(name="Show_Date",nullable = false)
	private LocalDate date;
	@Column(name="Show_Time",nullable = false)
	private LocalTime showTime;
	@Column(name="Ticket_price",nullable = false)
	private double ticketPrice;
	@Column(name="Status",nullable = false,length = 30)
	private String status;
	@Column(name="Last_Updated_Timestamp")
	private LocalDateTime lastUpdatedTimestamp;
	@Column(name="Admin_id",nullable = false)
	private String adminId;
	public int getShowTimeId() {
		return showTimeId;
	}
	public void setShowTimeId(int showTimeId) {
		this.showTimeId = showTimeId;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	
}

