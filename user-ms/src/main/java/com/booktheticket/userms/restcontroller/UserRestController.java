package com.booktheticket.userms.restcontroller;

import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booktheticket.userms.domain.model.ApiStatus;
import com.booktheticket.userms.domain.model.UserCredentialsDto;
import com.booktheticket.userms.domain.model.UserDetailsDto;
import com.booktheticket.userms.domain.model.UserDto;
import com.booktheticket.userms.exceptionhandling.InvalidRoleException;
import com.booktheticket.userms.exceptionhandling.PasswordNotMatchException;
import com.booktheticket.userms.exceptionhandling.UserAlreadyExistException;
import com.booktheticket.userms.exceptionhandling.UserNotFoundException;
import com.booktheticket.userms.exceptionhandling.UserValidationError;
import com.booktheticket.userms.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
//@Api("This is the Api to manage user information.")
public class UserRestController {
		
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ApiStatus status;

	private Function<BindingResult, String> getValdaitionErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	@PostMapping
	//@ApiOperation("Add a new User.")
	public ApiStatus addUser(@Valid @RequestBody UserDto userDetails, BindingResult beanValidationResults)
			throws UserValidationError, UserAlreadyExistException {

		if (beanValidationResults.hasErrors()) {

			throw new UserValidationError(getValdaitionErrorMessage.apply(beanValidationResults));
		}

		return service.registerUser(userDetails);

	}

	@PostMapping(path = "/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
	//@ApiOperation("Validate the user credentials.")
	public ApiStatus validateUserCredentails(@Valid @RequestBody UserCredentialsDto userCredentials,
			BindingResult beanValidationResults) throws UserValidationError, UserNotFoundException, PasswordNotMatchException, InvalidRoleException {

		if (beanValidationResults.hasErrors()) {
			throw new UserValidationError(getValdaitionErrorMessage.apply(beanValidationResults));
		}

		service.validateUser(userCredentials);
		status.setStatus(200);
		return status;
	}
	
	@GetMapping(path="/emailId/{emailId}")
	//@ApiOperation("Get the user details for the given email id.")
	public UserDetailsDto getUserDetails(  @PathVariable("emailId")   String emailId) throws UserNotFoundException {


		return service.getUserDetails(emailId);

	}

}
