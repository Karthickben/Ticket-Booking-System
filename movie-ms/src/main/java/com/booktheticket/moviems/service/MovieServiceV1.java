package com.booktheticket.moviems.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booktheticket.moviems.domain.entity.Movie;
import com.booktheticket.moviems.domain.model.ApiStatus;
import com.booktheticket.moviems.domain.model.MovieDetailsDto;
import com.booktheticket.moviems.domain.model.MovieInboundDto;
import com.booktheticket.moviems.domain.model.MovieListDto;
import com.booktheticket.moviems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.moviems.exceptionhandling.MovieWithSameNameLanguageFoundException;
import com.booktheticket.moviems.repo.MovieRepo;

@Service
public class MovieServiceV1 implements MovieService {

	@Autowired
	private MovieRepo repo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ApiStatus status;
	
	@Autowired
	private RestTemplate client;

	private Function<MovieInboundDto, Movie> convertToEntity = dto -> mapper.map(dto, Movie.class);
	private Function<Movie, MovieDetailsDto> convertToDetailsDto = entity -> mapper.map(entity, MovieDetailsDto.class);
	private Supplier<MovieNotFoundException> movieNotFound = () -> new MovieNotFoundException("Movie(s) not found");

	@Override
	public ApiStatus addMovie(MovieInboundDto movieDetails) throws MovieWithSameNameLanguageFoundException {
		Movie movie = convertToEntity.apply(movieDetails);
		
		List<Movie> list = repo.findByMovieNameAndLanguage(movie.getMovieName(),movie.getLanguage());
		if(!list.isEmpty()) {
			throw new MovieWithSameNameLanguageFoundException("Movie already exsists.");
		
		}
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
	public ApiStatus updateMovieDetails(int movieId, MovieInboundDto movieDetails) throws MovieNotFoundException, MovieWithSameNameLanguageFoundException {

		Optional<Movie> movieDet = repo.findById(movieId);
		if(!movieDet.isPresent()) {
			throw movieNotFound.get();
		}
		
		List<Movie> list = repo.findByMovieNameAndLanguage(movieDetails.getMovieName(),movieDetails.getLanguage());
		
		for(Movie m:list) {
			if(m.getMovieId()!=movieId) {
				throw new
				MovieWithSameNameLanguageFoundException("Movie already exsists.");
			}
			
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
	public ApiStatus deleteMovie(int movieId) throws MovieNotFoundException, MovieWithSameNameLanguageFoundException {
		Movie movie = repo.findById(movieId).orElseThrow(movieNotFound);
		
		String url = "http://TheatreMs/theatre-ms/v1/theatre-show/movie/"+movieId;
		ResponseEntity<Boolean> isMovieAddedToTheShow = client.getForEntity(url,
				Boolean.class);
		
		Boolean isMovieAdded = isMovieAddedToTheShow.getBody();
		System.out.println(isMovieAdded);
		if(!isMovieAdded) {
			throw new
			MovieWithSameNameLanguageFoundException("Movie has been reffered in the shows.");
			
		}
		
		
		repo.delete(movie);
		status.setStatus(200);
		return status;

	}

}
