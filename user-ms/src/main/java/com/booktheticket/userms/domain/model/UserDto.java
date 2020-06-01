package com.booktheticket.userms.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	@Email(message = "Invalid EmailId")
	private String emailId;
	@NotEmpty
	@NotNull
	@Size(max = 100 ,min = 1,message = "User Name size must be between 8 and 100")
	private String userName;
	@NotEmpty
	@NotNull
	@Size(max = 30, min = 10)
	private String phoneNumber;
	@Size(max = 30, min = 8)
	private String password;
	
	
	public UserDto() {
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
	@Override
	public String toString() {
		return "UserDto [emailId=" + emailId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", password="
				+ password + "]";
	}
	

}
