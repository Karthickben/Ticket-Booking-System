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
import com.booktheticket.theatrems.doamin.modal.TheatreByMovieOutListDto;
import com.booktheticket.theatrems.doamin.modal.TheatreDetailsOutDto;
import com.booktheticket.theatrems.doamin.modal.TheatreInDto;
import com.booktheticket.theatrems.doamin.modal.TheatreListDto;
import com.booktheticket.theatrems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreAlreadyExsists;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreValidationException;
import com.booktheticket.theatrems.service.TheatreServiceV1;

@RestController
@RequestMapping("/theatre")
@CrossOrigin
public class TheatreRestController {

	@Autowired
	private TheatreServiceV1 service;

	private Function<BindingResult, String> getValidationErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	private Function<String, TheatreValidationException> theatreValidationException = message -> new TheatreValidationException(
			message);

	@PostMapping
	public ApiStatus createNewTheatre(@RequestBody TheatreInDto theatre, BindingResult beanValidationResults)
			throws TheatreValidationException, TheatreAlreadyExsists {

		if (beanValidationResults.hasErrors()) {
			throw theatreValidationException.apply(getValidationErrorMessage.apply(beanValidationResults));
		}
		return service.addNewTheatre(theatre);
	}

	@GetMapping("/getdetails")
	public TheatreListDto getListOfTheatres() {
		return service.getTheatreList();
	}

	@PutMapping("/{theatreId}")
	public ApiStatus updateTheatreDetails(@PathVariable("theatreId") int theatreId,
			@Valid @RequestBody TheatreInDto theatre, BindingResult beanValidationResults)
			throws TheatreNotFoundException, TheatreValidationException {
		if (beanValidationResults.hasErrors()) {
			throw theatreValidationException.apply(getValidationErrorMessage.apply(beanValidationResults));
		}

		return service.updateTheatre(theatre, theatreId);

	}

	@DeleteMapping("/{theatreId}/delete")
	public ApiStatus deleteTheTheatre(@PathVariable("theatreId") int theatreId) throws TheatreNotFoundException {
		return service.deleteTheatre(theatreId);
	}

	@GetMapping("/{theatreId}/getdetails")
	public TheatreDetailsOutDto getTheatreDetails(@PathVariable("theatreId") int theatreId)
			throws TheatreNotFoundException {
		return service.getTheatreDetails(theatreId);

	}

	@GetMapping("/movie/{moviename}/location/{location}/getdetails")
	public TheatreByMovieOutListDto getTheatresListByNameLocation(@PathVariable("moviename") String movieName,
			@PathVariable("location") String city) throws MovieNotFoundException {
		return service.getTheatresByNameLocation(movieName, city);
	}
	
	
}
