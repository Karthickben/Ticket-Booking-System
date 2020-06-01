package com.booktheticket.userms.service;



import com.booktheticket.userms.domain.model.UserCredentialsDto;
import com.booktheticket.userms.domain.model.UserDetailsDto;
import com.booktheticket.userms.domain.model.UserDto;
import com.booktheticket.userms.exceptionhandling.InvalidRoleException;
import com.booktheticket.userms.exceptionhandling.PasswordNotMatchException;
import com.booktheticket.userms.exceptionhandling.UserAlreadyExistException;
import com.booktheticket.userms.exceptionhandling.UserNotFoundException;

public interface UserService {
	
	
	String registerUser(UserDto userDetails) throws UserAlreadyExistException;
	String validateUser(UserCredentialsDto userCredentials) throws UserNotFoundException, PasswordNotMatchException, InvalidRoleException;
	UserDetailsDto getUserDetails(String emailId) throws UserNotFoundException;
	
	

}
