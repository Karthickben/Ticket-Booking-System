package com.booktheticket.theatrems.restcontroller;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booktheticket.theatrems.doamin.entity.Screen;
import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.ScreenSeatingDetailsOut;
import com.booktheticket.theatrems.doamin.modal.ShowInDto;
import com.booktheticket.theatrems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScheduledShowsFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowValidationException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.service.ShowServiceV1;

@RestController
@RequestMapping("/theatre-show")
@CrossOrigin
public class ShowRestController {

	@Autowired
	private ShowServiceV1 service;

	private Function<BindingResult, String> getValidationErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	private Function<String, ShowValidationException> showValidationException = message -> new ShowValidationException(
			message);

	@PostMapping("/{theareId}/screen/{screenId}/show")
	public ApiStatus addNewShow(@PathVariable("theareId") int theareId, @PathVariable("screenId") int screenId,
			@Valid @RequestBody ShowInDto show, BindingResult results)
			throws TheatreNotFoundException, ScreenNotFoundException, MovieNotFoundException, ShowValidationException, ScheduledShowsFoundException {

		if (results.hasErrors()) {
			throw showValidationException.apply(getValidationErrorMessage.apply(results));
		}

		return service.addShow(theareId, screenId, show);

	}

	@PutMapping("/{theareId}/screen/{screenId}/show/{showId}")
	public ApiStatus updateTheShow(@PathVariable("theareId") int theareId, @PathVariable("screenId") int screenId,
			@PathVariable("showId") int showId, @Valid @RequestBody ShowInDto show, BindingResult results)
			throws TheatreNotFoundException, ScreenNotFoundException, MovieNotFoundException, ShowNotFoundException,
			ShowValidationException {

		if (results.hasErrors()) {
			throw showValidationException.apply(getValidationErrorMessage.apply(results));
		}

		return service.updateShow(theareId, screenId, showId, show);

	}
	
	

	@DeleteMapping("/{theareId}/screen/{screenId}/show/{showId}/delete")
	public ApiStatus deleteShow(@PathVariable("theareId") int theareId, @PathVariable("screenId") int screenId,
			@PathVariable("showId") int showId)
			throws ShowNotFoundException, TheatreNotFoundException, ScreenNotFoundException {

		return service.deleteTheShow(showId, theareId, screenId);

	}
	
		

}
