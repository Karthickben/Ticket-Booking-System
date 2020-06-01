package com.booktheticket.userms.service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktheticket.userms.domain.entity.User;
import com.booktheticket.userms.domain.model.ApiStatus;
import com.booktheticket.userms.domain.model.UserCredentialsDto;
import com.booktheticket.userms.domain.model.UserDetailsDto;
import com.booktheticket.userms.domain.model.UserDto;
import com.booktheticket.userms.exceptionhandling.InvalidRoleException;
import com.booktheticket.userms.exceptionhandling.PasswordNotMatchException;
import com.booktheticket.userms.exceptionhandling.UserAlreadyExistException;
import com.booktheticket.userms.exceptionhandling.UserNotFoundException;
import com.booktheticket.userms.repository.UserRepo;

@Service
public class UserServiceV1 implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ApiStatus status;
	
	
	private Function<UserDto,User> convertToEntity = dto ->  modelMapper.map(dto, User.class);
	private Function<User,UserDetailsDto> convertToDto = entity ->  modelMapper.map(entity, UserDetailsDto.class);
	private Supplier<UserNotFoundException> userNotFound = () -> new UserNotFoundException("Invalid User Id");

	@Override
	public ApiStatus registerUser(UserDto userDetails) throws UserAlreadyExistException {
		
		Optional<User> checkUser = repo.findById(userDetails.getEmailId());
		System.out.println("--------------------------------------------------");
		
		if(checkUser.isPresent()) {
			throw new UserAlreadyExistException("User with Id "+userDetails.getEmailId()+" is alreay exsists.");
		}
		User user = convertToEntity.apply(userDetails);
		user.setRole("User");
		user.setLastUpdatedTimestamp(LocalDateTime.now());	
		repo.save(user);
		status.setStatus(200);
		return  status;
	}

	@Override
	public ApiStatus validateUser(UserCredentialsDto userCredentials) throws UserNotFoundException, PasswordNotMatchException, InvalidRoleException {
		
		 	User user = repo.findById(userCredentials.getEmailId()).orElseThrow(userNotFound);
		 	
		 		if(!user.getRole().equals(userCredentials.getRole())) {
		 			
		 			throw new InvalidRoleException("Role Mismatch");
		 		}
		 		
		 		if(!user.getPassword().equals(userCredentials.getPassword())) {
		 			throw new PasswordNotMatchException("Wrong Password");
		 		}
		 	
		 	
		 		status.setStatus(200);
		return status;
	}

	@Override
	public UserDetailsDto getUserDetails(String emailId) throws UserNotFoundException {
		 User user = repo.findById(emailId).orElseThrow(userNotFound);
		 return convertToDto.apply(user);

	}

}
