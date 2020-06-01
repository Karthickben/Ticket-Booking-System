package com.booktheticket.userms.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCredentialsDto {

	@Email(message = "Invalid EmailId")
	private String emailId;
	@Size(min = 8, max = 60,message = "Password should be the length of 8 characters.")
	private String password;
	@NotEmpty
	@NotNull
	private String role;

	public UserCredentialsDto() {
		super();
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

}
