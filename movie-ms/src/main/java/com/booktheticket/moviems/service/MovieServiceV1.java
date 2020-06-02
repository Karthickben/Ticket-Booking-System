package com.booktheticket.moviems.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktheticket.moviems.domain.entity.Movie;
import com.booktheticket.moviems.domain.model.ApiStatus;
import com.booktheticket.moviems.domain.model.MovieDetailsDto;
import com.booktheticket.moviems.domain.model.MovieInboundDto;
import com.booktheticket.moviems.domain.model.MovieListDto;
import com.booktheticket.moviems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.moviems.repo.MovieRepo;

@Service
public class MovieServiceV1 implements MovieService {

	@Autowired
	private MovieRepo repo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ApiStatus status;

	private Function<MovieInboundDto, Movie> convertToEntity = dto -> mapper.map(dto, Movie.class);
	private Function<Movie, MovieDetailsDto> convertToDetailsDto = entity -> mapper.map(entity, MovieDetailsDto.class);
	private Supplier<MovieNotFoundException> movieNotFound = () -> new MovieNotFoundException("Movie(s) not found");

	@Override
	public ApiStatus addMovie(MovieInboundDto movieDetails) {
		Movie movie = convertToEntity.apply(movieDetails);
		movie.setLastUpdatedTimestamp(LocalDateTime.now());
		movie.setRating(0.0);
		movie.setNumberOfRatings(0);
		repo.save(movie);
		status.setStatus(200);
		return status;

	}

	@Override
	public MovieListDto getMovies() throws MovieNotFoundException {
		List<MovieDetailsDto> listOfMovies = repo.findAll().stream().map(convertToDetailsDto)
				.collect(Collectors.toList());
		if (listOfMovies.isEmpty()) {
			throw movieNotFound.get();
		}
		MovieListDto listDto = new MovieListDto();
		listDto.setListOfMovies(listOfMovies);
		listDto.setResponseDescription("List of movies");
		return listDto;
	}

	@Override
	public MovieListDto getMovieByName(String movieName) throws MovieNotFoundException {
		List<MovieDetailsDto> listOfMovies = repo.findAllByMovieName(movieName).stream().map(convertToDetailsDto)
				.collect(Collectors.toList());
		if (listOfMovies.isEmpty()) {
			throw movieNotFound.get();
		}
		MovieListDto listDto = new MovieListDto();
		listDto.setListOfMovies(listOfMovies);
		listDto.setResponseDescription("List of movies based on name");
		return listDto;

	}

	@Override
	public MovieDetailsDto getMovieById(int movieId) throws MovieNotFoundException {
		Movie movie = repo.findById(movieId).orElseThrow(movieNotFound);
		return convertToDetailsDto.apply(movie);
	}

	@Override
	public ApiStatus updateMovieDetails(int movieId, MovieInboundDto movieDetails) throws MovieNotFoundException {

		Optional<Movie> movieDet = repo.findById(movieId);
		if(!movieDet.isPresent()) {
			throw movieNotFound.get();
		}

		Movie movie = convertToEntity.apply(movieDetails);
		movie.setMovieId(movieId);
		movie.setRating(movieDet.get().getRating());
		movie.setNumberOfRatings(movieDet.get().getNumberOfRatings());
		movie.setLastUpdatedTimestamp(LocalDateTime.now());
		repo.save(movie);
		status.setStatus(200);
		return status;
	}

	@Override
	public ApiStatus rateMovie(int movieId, double rateing) throws MovieNotFoundException {
		Movie movie2 = repo.findById(movieId).orElseThrow(movieNotFound);

		double newRating = 0;
		double rateings = movie2.getRating();
		int numOfRatings = movie2.getNumberOfRatings();
		newRating += (rateing + (rateings * numOfRatings)) / (numOfRatings + 1);
		movie2.setRating(newRating);
		movie2.setNumberOfRatings(numOfRatings + 1);
		repo.save(movie2);
		status.setStatus(200);
		return status;

	}

	@Override
	public ApiStatus deleteMovie(int movieId) throws MovieNotFoundException {
		Movie movie = repo.findById(movieId).orElseThrow(movieNotFound);
		repo.delete(movie);
		status.setStatus(200);
		return status;

	}

}
