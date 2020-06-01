package com.booktheticket.moviems.service;

import com.booktheticket.moviems.domain.model.ApiStatus;
import com.booktheticket.moviems.domain.model.MovieDetailsDto;
import com.booktheticket.moviems.domain.model.MovieInboundDto;
import com.booktheticket.moviems.domain.model.MovieListDto;
import com.booktheticket.moviems.exceptionhandling.MovieNotFoundException;

public interface MovieService {
	
	ApiStatus addMovie(MovieInboundDto movie);
	MovieListDto getMovies() throws MovieNotFoundException;
	MovieListDto getMovieByName(String movieName) throws MovieNotFoundException;
	MovieDetailsDto getMovieById(int movieId) throws MovieNotFoundException;
	ApiStatus updateMovieDetails(int movieId,MovieInboundDto movie) throws MovieNotFoundException;
	ApiStatus deleteMovie(int movieId) throws MovieNotFoundException;
	ApiStatus rateMovie(int movieId, double rateing) throws MovieNotFoundException;
	
}
