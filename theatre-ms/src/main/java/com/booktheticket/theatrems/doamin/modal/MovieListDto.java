package com.booktheticket.theatrems.doamin.modal;

import java.util.ArrayList;
import java.util.List;

public class MovieListDto {
	
	private String responseDescription="list of movies by name";
	private List<MovieDetailsDto> listOfMovies;
	
	{
		listOfMovies=new ArrayList<>();
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public List<MovieDetailsDto> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(List<MovieDetailsDto> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}
	
}
