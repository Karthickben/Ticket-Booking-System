package com.booktheticket.moviems.restcontroller;

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

import com.booktheticket.moviems.domain.model.MovieDetailsDto;
import com.booktheticket.moviems.domain.model.MovieInboundDto;
import com.booktheticket.moviems.domain.model.MovieListDto;
import com.booktheticket.moviems.domain.model.MovieRateDto;
import com.booktheticket.moviems.exceptionhandling.BeanValidationException;
import com.booktheticket.moviems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.moviems.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieRestController {

	@Autowired
	private MovieService service;

	private Function<BindingResult, String> getValdaitionErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	@PostMapping
	public String createNewMovie(@Valid @RequestBody MovieInboundDto movie, BindingResult beanValidationResults)
			throws BeanValidationException {

		if (beanValidationResults.hasErrors()) {

			throw new BeanValidationException(getValdaitionErrorMessage.apply(beanValidationResults));
		}

		return service.addMovie(movie);
	}

	@GetMapping("/getdetails")
	public MovieListDto getMovieList() throws MovieNotFoundException {
		return service.getMovies();
	}

	@GetMapping("/name/{movieName}/getdetails")
	public MovieListDto getMovieByName(@PathVariable("movieName") String movieName) throws MovieNotFoundException {
		return service.getMovieByName(movieName);
	}

	@GetMapping("/id/{movieId}/getdetails")
	public MovieDetailsDto getMovieById(@PathVariable("movieId") int movieId) throws MovieNotFoundException {
		return service.getMovieById(movieId);
	}

	@PutMapping("/{movieId}")
	public String updateMovieDetails(@PathVariable("movieId") int movieId, @Valid @RequestBody MovieInboundDto movie,
			BindingResult beanValidationResults) throws BeanValidationException, MovieNotFoundException {
		if (beanValidationResults.hasErrors()) {

			throw new BeanValidationException(getValdaitionErrorMessage.apply(beanValidationResults));
		}
		return service.updateMovieDetails(movieId, movie);
	}

	@PutMapping("/{movieId}/rate")
	public String rateMovie(@RequestBody  MovieRateDto dto,@PathVariable("movieId") int movieId)
			throws MovieNotFoundException {
		System.out.println("Inside"+movieId+" "+dto.getRateing());
		return service.rateMovie(movieId, dto.getRateing());
	}

	@DeleteMapping("/{movieId}")
	public String deleteMovie(@PathVariable("movieId")int movieId) throws MovieNotFoundException {
		return service.deleteMovie(movieId);

	}

}