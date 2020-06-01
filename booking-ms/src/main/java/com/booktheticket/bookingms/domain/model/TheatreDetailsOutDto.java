package com.booktheticket.bookingms.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TheatreDetailsOutDto {
	

	private int theatreId;	
	private String theatreName;
	private String buildingName;
	private String area;
	private String city;
	private String state;
	private String theatreType;
	private int totalScreens;
	private String theatreStatus;
	private String adminId;
	private String lastUpdatedTimestamp;
	private List<ScreenOutDto> screens;
	{
		screens = new ArrayList<>();
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTheatreType() {
		return theatreType;
	}
	public void setTheatreType(String theatreType) {
		this.theatreType = theatreType;
	}
	public int getTotalScreens() {
		return totalScreens;
	}
	public void setTotalScreens(int totalScreens) {
		this.totalScreens = totalScreens;
	}
	public String getTheatreStatus() {
		return theatreStatus;
	}
	public void setTheatreStatus(String theatreStatus) {
		this.theatreStatus = theatreStatus;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	public List<ScreenOutDto> getScreens() {
		return screens;
	}
	public void setScreens(List<ScreenOutDto> screens) {
		this.screens = screens;
	}
	
	
	
	
}
