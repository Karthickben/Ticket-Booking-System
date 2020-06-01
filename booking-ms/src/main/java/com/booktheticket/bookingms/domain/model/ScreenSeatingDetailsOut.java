package com.booktheticket.bookingms.domain.model;

public class ScreenSeatingDetailsOut {
	
	private  int screenId;
	private String screenName;
	private int noOfSeatingRows;
	private int noOfSeatingColumns;
	
	
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
	@Override
	public String toString() {
		return "ScreenSeatingDetailsOut [screenId=" + screenId + ", screenName=" + screenName + ", noOfSeatingRows="
				+ noOfSeatingRows + ", noOfSeatingColumns=" + noOfSeatingColumns + "]";
	}
	

}
