package com.booktheticket.theatrems.doamin.modal;

import java.util.List;

public class TheatreListDto {
	
	private String description;
	private List<TheatreOutDto> listOfTheatres;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<TheatreOutDto> getListOfTheatres() {
		return listOfTheatres;
	}
	public void setListOfTheatres(List<TheatreOutDto> listOfTheatres) {
		this.listOfTheatres = listOfTheatres;
	}
	
}
