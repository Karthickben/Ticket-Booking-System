package com.booktheticket.theatrems.doamin.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "screen")
@Table(name="Screen")
public class Screen {
	
	@Id
	@SequenceGenerator(name = "sid",initialValue = 210000,allocationSize = 1)
	@GeneratedValue(generator = "sid",strategy = GenerationType.SEQUENCE)
	@Column(name="ScreenID",length = 20)
	private int screenId;
	@ManyToOne
	@JoinColumn(name="Theatre_Id")
	private  Theatre theatre;
	@Column(name="Screen_Name",nullable = false,length = 100)
	private String screenName;
	@Column(name="Screen_Status",nullable = false,length = 50)
	private String screenStatus;
	@Column(name="No_Of_Seating_Rows",nullable = false,length = 4)
	private int noOfSeatingRows;
	@Column(name="No_Of_Seating_Columns",nullable = false,length = 4)
	private int noOfSeatingColumns;
	@Column(name="Admin_Id",nullable = false,length = 50)
	private String adminId;
	@Column(name="Last_Updated_Timestamp",nullable = false)
	private LocalDateTime lastUpdatedTimestamp;
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
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
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

}
