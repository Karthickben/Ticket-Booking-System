package com.booktheticket.theatrems.restcontroller;

import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.ShowTimeInDto;
import com.booktheticket.theatrems.doamin.modal.TheatreDetailsOutDto;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowTimeNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowTimeValidationException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.service.ShowTimeServiceV1;

@RestController
@RequestMapping("/theatre-showTime")
public class ShowTimeRestController {

	@Autowired
	private ShowTimeServiceV1 service;

	private Function<BindingResult, String> getValidationErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	private Function<String, ShowTimeValidationException> showValidationException = message -> new ShowTimeValidationException(
			message);

	
	@PostMapping("/{theatreId}/screen/{screenId}/show/{showId}/showtime")
	public ApiStatus addNewShowTime(@PathVariable("theatreId") int theatreId, @PathVariable("screenId") int screenId,
			@PathVariable("showId") int showId, @Valid @RequestBody ShowTimeInDto showTime,BindingResult results)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException, ShowTimeValidationException {
		
		if(results.hasErrors()) {
			throw showValidationException.apply(getValidationErrorMessage.apply(results));
		}
		return service.addShowTime(theatreId, screenId, showId, showTime);

	}

	@PutMapping("/{theatreId}/screen/{screenId}/show/{showId}/showtime/{showTimeId}")
	public ApiStatus updateTheShowTime(@PathVariable("theatreId") int theatreId, @PathVariable("screenId") int screenId,
			@PathVariable("showId") int showId, @PathVariable("showTimeId") int showTimeId,
			@Valid @RequestBody ShowTimeInDto showTime,BindingResult results)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException, ShowTimeNotFoundException, ShowTimeValidationException {
		
		
		if(results.hasErrors()) {
			throw showValidationException.apply(getValidationErrorMessage.apply(results));
		}
		
		return service.updateShowTime(theatreId, screenId, showId, showTimeId, showTime);

	}

	@DeleteMapping("/{theatreId}/screen/{screenId}/show/{showId}/showtime/{showTimeId}/delete")
	public ApiStatus deleteTheShowTime(@PathVariable("theatreId") int theatreId, @PathVariable("screenId") int screenId,
			@PathVariable("showId") int showId, @PathVariable("showTimeId") int showTimeId)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException, ShowTimeNotFoundException {
		return service.deleteShowTime(theatreId, screenId, showId, showTimeId);

	}
	

}
