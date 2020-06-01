package com.booktheticket.theatrems.doamin.modal;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShowTimeInDto {
	
	
	@NotEmpty @NotNull
	private String date;
	@NotNull @NotEmpty
	private String showTime;
	@Min(1)
	private double ticketPrice;
	@NotNull @NotEmpty @Size(max=30)
	private String status;
	@NotNull @NotEmpty @Size(max=50,min=1)
	private String adminId;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	
}
