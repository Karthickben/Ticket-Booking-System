package com.booktheticket.bookingms.domain.model;

import java.util.List;

public class SeatingChartOutDto {
	
	public String description = "Seating chart";
	public List<SeatingoutDto> seatingChart;
	
	public String getDescription() {
		return description;
	}
	public List<SeatingoutDto> getSeatingChart() {
		return seatingChart;
	}
	public void setSeatingChart(List<SeatingoutDto> seatingChart) {
		this.seatingChart = seatingChart;
	}
	
	

}
