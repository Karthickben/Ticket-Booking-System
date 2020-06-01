package com.booktheticket.theatrems.doamin.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="theatre")
@Table(name="Theatre")
public class Theatre {
	
	@Id
	@SequenceGenerator(name = "tid",initialValue = 110000,allocationSize = 1)
	@GeneratedValue(generator = "tid",strategy = GenerationType.SEQUENCE)
	@Column(name="Theatre_Id")
	private int theatreId;
	@Column(name="Theatre_Name",nullable = false,length = 150)
	private String theatreName;
	@Column(name="Building_Name",length = 100)
	private String buildingName;
	@Column(name="Area",nullable = false,length = 100)
	private String area;
	@Column(name="City",nullable = false,length = 100)
	private String city;
	@Column(name="State",nullable =false,length = 100 )
	private String state;
	@Column(name="Theatre_Type",nullable = false,length = 50)
	private String theatreType;
	@Column(name="Total_Screens",nullable = false,length = 2)
	private int totalScreens;
	@Column(name="Screen_Status",nullable = false,length = 100)
	private String theatreStatus;
	@Column(name="Last_Updated_Timestamp",nullable = false)
	private LocalDateTime lastUpdatedTimestamp;
	@Column(name="Admin_Id",nullable = false,length = 50)
	private String adminId;
	
	
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

	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
		
}
