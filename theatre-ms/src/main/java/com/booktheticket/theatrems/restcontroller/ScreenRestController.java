package com.booktheticket.theatrems.restcontroller;

import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.ScreenInDto;
import com.booktheticket.theatrems.doamin.modal.ScreenSeatingDetailsOut;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScreenValidationException;
import com.booktheticket.theatrems.exceptionhandling.ShowsFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.service.ScreenServiceV1;

@RestController
@RequestMapping("/theatre-screen")
@CrossOrigin
public class ScreenRestController {

	@Autowired
	private ScreenServiceV1 service;

	private Function<BindingResult, String> getValidationErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	private Function<String, ScreenValidationException> screenValidationException = message -> new ScreenValidationException(
			message);

	@PostMapping(path = "/{theatreId}/screen")
	public ApiStatus addNewScreen(@PathVariable("theatreId") int theatreId, @Valid @RequestBody ScreenInDto screen,
			BindingResult beanValidationResults) throws TheatreNotFoundException, ScreenValidationException {

		if (beanValidationResults.hasErrors()) {
			throw screenValidationException.apply(getValidationErrorMessage.apply(beanValidationResults));
		}

		return service.addScreen(screen, theatreId);

	}

	@PutMapping(path = "/{theatreId}/screen/{screenId}")
	public ApiStatus updateScreenDetails(@PathVariable("screenId") int screenId,
			@PathVariable("theatreId") int theatreId, @Valid @RequestBody ScreenInDto screen,
			BindingResult beanValidationResults)
			throws TheatreNotFoundException, ScreenNotFoundException, ScreenValidationException {

		if (beanValidationResults.hasErrors()) {
			throw screenValidationException.apply(getValidationErrorMessage.apply(beanValidationResults));
		}
		return service.updateScreen(screen, screenId, theatreId);

	}

	@DeleteMapping(path = "/{theatreId}/screen/{screenId}/delete")
	public ApiStatus deleteScreenDetails(@PathVariable("screenId") int screenId,
			@PathVariable("theatreId") int theatreId) throws TheatreNotFoundException, ScreenNotFoundException {
		return service.deleteSCreen(screenId, theatreId);
	}

	@GetMapping(path = "/screen/{screenId}/getSeatDetails")
	public ScreenSeatingDetailsOut getScreenSeatingDetails(@PathVariable("screenId") int screenId)
			throws ScreenNotFoundException, ShowsFoundException {
		return service.getSeatingDetails(screenId);

	}
	
	

}
