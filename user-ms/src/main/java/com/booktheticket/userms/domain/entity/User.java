package com.booktheticket.userms.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "User_Detail")
public class User {

	@Id
	@Column(name = "Email_Id", length = 100)
	private String emailId;
	@Column(name = "User_Name", length = 100,nullable = false)
	private String userName;
	@Column(name = "Phone_Number", length = 30, unique = true,nullable = false)
	private String phoneNumber;
	@Column(name = "Password",nullable = false,length = 60)
	private String password;
	@Column(name = "Role", length = 50,nullable = false)
	private String role;
	@Column(name = "Last_Updated_Timestamp",nullable = false)
	private LocalDateTime lastUpdatedTimestamp;

	public User() {
		super();

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", role=" + role + ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + "]";
	}

	
}
