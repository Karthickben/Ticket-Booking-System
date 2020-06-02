package com.booktheticket.theatrems.doamin.modal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScreenInDto {
	

	@Min(110000)
	private  int theatreId;
	@NotNull @NotEmpty @Size(max = 100,min = 1)
	private String screenName;
	@NotNull @NotEmpty @Size(max = 50,min = 1)
	private String screenStatus;
	@NotNull @NotEmpty @Size(max = 50,min = 1)
	private String adminId;
	@Min(1) @Max(9999)
	private int noOfSeatingRows;
	@Min(1) @Max(9999)
	private int noOfSeatingColumns;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
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
	
	
	
}
