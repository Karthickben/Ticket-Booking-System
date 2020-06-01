package com.booktheticket.moviems.service;

import com.booktheticket.moviems.domain.model.MovieDetailsDto;
import com.booktheticket.moviems.domain.model.MovieInboundDto;
import com.booktheticket.moviems.domain.model.MovieListDto;
import com.booktheticket.moviems.exceptionhandling.MovieNotFoundException;

public interface MovieService {
	
	String addMovie(MovieInboundDto movie);
	MovieListDto getMovies() throws MovieNotFoundException;
	MovieListDto getMovieByName(String movieName) throws MovieNotFoundException;
	MovieDetailsDto getMovieById(int movieId) throws MovieNotFoundException;
	String updateMovieDetails(int movieId,MovieInboundDto movie) throws MovieNotFoundException;
	String deleteMovie(int movieId) throws MovieNotFoundException;
	String rateMovie(int movieId, double rateing) throws MovieNotFoundException;
	
}
