package com.booktheticket.theatrems.doamin.modal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TheatreInDto {
	
	@NotNull @NotEmpty @Size(max = 150,min=1)
	private String theatreName;
	@NotNull @NotEmpty @Size(max = 100,min=1)
	private String buildingName;
	@NotNull @NotEmpty @Size(max = 100,min=1)
	private String area;
	@NotNull @NotEmpty @Size(max = 100,min=1)
	private String city;
	@NotNull @NotEmpty @Size(max = 100,min=1)
	private String state;
	@NotNull @NotEmpty @Size(max = 50,min=1)
	private String theatreType;
	@Min(1)@Max(99)
	private int totalScreens;
	@NotNull @NotEmpty @Size(max = 100,min=1)
	private String theatreStatus;
	@NotNull @NotEmpty @Size(max = 50,min=1)
	private String adminId;
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
	

}
