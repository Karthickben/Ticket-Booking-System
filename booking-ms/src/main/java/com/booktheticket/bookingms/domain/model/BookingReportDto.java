package com.booktheticket.bookingms.domain.model;

import java.util.ArrayList;
import java.util.List;

public class BookingReportDto {
	
	private String description = "Report on booking";
	private List<TicketDto> listOfBookingDetails;
	
	{
		listOfBookingDetails = new ArrayList<>();
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TicketDto> getListOfBookingDetails() {
		return listOfBookingDetails;
	}

	public void setListOfBookingDetails(List<TicketDto> listOfBookingDetails) {
		this.listOfBookingDetails = listOfBookingDetails;
	}
	
	
	

}
