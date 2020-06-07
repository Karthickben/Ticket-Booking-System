package com.booktheticket.theatrems.doamin.modal;

import java.util.ArrayList;
import java.util.List;


public class ScreenOutDto {
	

	private  int screenId;
	private String screenName;
	private String screenStatus;
	private String adminId;
	private int noOfSeatingRows;
	private int noOfSeatingColumns;
	private String lastUpdatedTimestamp;
	private int showId;
	private String  runningMovie;
	private int movieId;
	private List<ShowTimeOutDto> upcomingShows;
	
	{
		upcomingShows = new ArrayList<>();
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getScreenStatus() {
		return screenStatus;
	}
	public void setScreenStatus(String screenStatus) {
		this.screenStatus = screenStatus;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public int getNoOfSeatingRows() {
		return noOfSeatingRows;
	}
	public void setNoOfSeatingRows(int noOfSeatingRows) {
		this.noOfSeatingRows = noOfSeatingRows;
	}
	public int getNoOfSeatingColumns() {
		return noOfSeatingColumns;
	}
	public void setNoOfSeatingColumns(int noOfSeatingColumns) {
		this.noOfSeatingColumns = noOfSeatingColumns;
	}
	public String getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public String getRunningMovie() {
		return runningMovie;
	}
	public void setRunningMovie(String runningMovie) {
		this.runningMovie = runningMovie;
	}
	public List<ShowTimeOutDto> getUpcomingShows() {
		return upcomingShows;
	}
	public void setUpcomingShows(List<ShowTimeOutDto> upcomingShows) {
		this.upcomingShows = upcomingShows;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	
	
	
}
