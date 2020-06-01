package com.booktheticket.theatrems.doamin.modal;

import java.util.ArrayList;
import java.util.List;

public class TheatreByMovieOutListDto {
	

	private String description="List of movies by name and location";
	
	
	private List<TheatreByMovieOutDto> listOfTheatre;
	{
		listOfTheatre = new ArrayList<>();
		}
	public String getDescription() {
		return description;
	}

	public List<TheatreByMovieOutDto> getListOfTheatre() {
		return listOfTheatre;
	}
	public void setListOfTheatre(List<TheatreByMovieOutDto> listOfTheatre) {
		this.listOfTheatre = listOfTheatre;
	}
	
	
	

}
