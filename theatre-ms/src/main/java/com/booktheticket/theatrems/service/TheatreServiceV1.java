package com.booktheticket.theatrems.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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

import com.booktheticket.theatrems.doamin.entity.Screen;
import com.booktheticket.theatrems.doamin.entity.Show;
import com.booktheticket.theatrems.doamin.entity.ShowTimings;
import com.booktheticket.theatrems.doamin.entity.Theatre;
import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.MovieDetailsDto;
import com.booktheticket.theatrems.doamin.modal.MovieListDto;
import com.booktheticket.theatrems.doamin.modal.ScreenOutDto;
import com.booktheticket.theatrems.doamin.modal.ShowTimeOutDto;
import com.booktheticket.theatrems.doamin.modal.TheatreByMovieOutDto;
import com.booktheticket.theatrems.doamin.modal.TheatreByMovieOutListDto;
import com.booktheticket.theatrems.doamin.modal.TheatreDetailsOutDto;
import com.booktheticket.theatrems.doamin.modal.TheatreInDto;
import com.booktheticket.theatrems.doamin.modal.TheatreListDto;
import com.booktheticket.theatrems.doamin.modal.TheatreOutDto;
import com.booktheticket.theatrems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScreenFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreAlreadyExsists;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.repository.ScreenRepo;
import com.booktheticket.theatrems.repository.ShowRepo;
import com.booktheticket.theatrems.repository.ShowTimingRepo;
import com.booktheticket.theatrems.repository.TheatreRepo;

@Service
public class TheatreServiceV1 {

	@Autowired
	private TheatreRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ShowTimingRepo stRepo;

	@Autowired
	private ShowRepo showRepo;

	@Autowired
	private ScreenRepo sRepo;

	@Autowired
	private RestTemplate client;

	@Autowired
	private ApiStatus status;

	private Function<TheatreInDto, Theatre> convertToTheatreEntity = dto -> mapper.map(dto, Theatre.class);

	private Function<Theatre, TheatreOutDto> convertToTheatreDetailsDto = entity -> mapper.map(entity,
			TheatreOutDto.class);

	private Function<Theatre, TheatreDetailsOutDto> convertToTheatreFullDetailsDto = entity -> mapper.map(entity,
			TheatreDetailsOutDto.class);

	private Function<ShowTimings, ShowTimeOutDto> convertToShowTimingsFullDetailsDto = entity -> mapper.map(entity,
			ShowTimeOutDto.class);

	private Function<Screen, ScreenOutDto> convertToScreenFullDetailsDto = entity -> mapper.map(entity,
			ScreenOutDto.class);

	private Supplier<TheatreNotFoundException> theatreNotFound = () -> new TheatreNotFoundException(
			"Theatre not found.");

	private Show show;

	public ApiStatus addNewTheatre(TheatreInDto theatre) throws TheatreAlreadyExsists {
		
		List<Theatre> t = repo.findByTheatreNameAndArea(theatre.getTheatreName(),theatre.getArea());
		
		if(!t.isEmpty()) {
			
			throw new TheatreAlreadyExsists("Theatre with name "+theatre.getTheatreName() +" is already exsists in area "
					+ theatre.getArea()+".");
			
			
		}
		
		Theatre theatre1 = convertToTheatreEntity.apply(theatre);
			

		theatre1.setLastUpdatedTimestamp(LocalDateTime.now());
		repo.save(theatre1);
		status.setStatus(200);

		return status;
	}

	public TheatreListDto getTheatreList() {

		List<TheatreOutDto> listOfTheatres = repo.findAll().stream().map(convertToTheatreDetailsDto)
				.collect(Collectors.toList());
		TheatreListDto listDto = new TheatreListDto();
		listDto.setDescription("List of Theatres");
		listDto.setListOfTheatres(listOfTheatres);
		return listDto;
	}

	public ApiStatus updateTheatre(TheatreInDto theatre, int theatreId) throws TheatreNotFoundException {
		Optional<Theatre> findById = repo.findById(theatreId);
		if (!findById.isPresent()) {
			throw theatreNotFound.get();
		}
		Theatre theatre1 = convertToTheatreEntity.apply(theatre);
		theatre1.setTheatreId(theatreId);
		theatre1.setLastUpdatedTimestamp(LocalDateTime.now());
		repo.save(theatre1);
		status.setStatus(200);
		return status;

	}

	public ApiStatus deleteTheatre(int theatreId) throws TheatreNotFoundException, ScreenFoundException {
		Optional<Theatre> findById = repo.findById(theatreId);
		if (!findById.isPresent()) {
			throw theatreNotFound.get();
		}
		
		List<Screen> findByTheatre = sRepo.findByTheatre(findById.get());
		if(!findByTheatre.isEmpty()) {
			throw new ScreenFoundException("Screen(s) exsists for this theatre");
			
		}
		

		repo.delete(findById.get());
		status.setStatus(200);
		return status;
	}

	public TheatreByMovieOutListDto getTheatresByNameLocation(String movieName, String city)
			throws MovieNotFoundException, TheatreNotFoundException {
		System.out.println(movieName + " " + city);
		String movieuri = "http://MOVIEMS/movie-ms/v1/movie/name/" + movieName + "/getdetails";

		ResponseEntity<MovieListDto> movies = client.getForEntity(movieuri, MovieListDto.class);
		List<MovieDetailsDto> movieList = movies.getBody().getListOfMovies();
		TheatreByMovieOutListDto tlist = new TheatreByMovieOutListDto();
		
		List<Integer> screenShow = new ArrayList<>();
		
		if (movieList.isEmpty()) {
			throw new MovieNotFoundException("Movie not found");
		}
		for (MovieDetailsDto movieDetails : movieList) {

			List<Show> listOfShowsByMovie = showRepo.findByMovieId(movieDetails.getMovieId());

			for (Show s : listOfShowsByMovie) {
				Optional<Screen> screen = sRepo.findById(s.getScreen().getScreenId());
				Optional<Theatre> theatre = repo.findById(screen.get().getTheatre().getTheatreId());
				List<Show> findByScreen = showRepo.findByScreen(screen.get());
				
				Optional<Show> max = findByScreen.stream().max(Comparator.comparing(Show::getLastUpdatedTimestamp));
				
				if(!max.isPresent()) {
					throw theatreNotFound.get();
					
				}
				
				
			
				if (theatre.get().getCity().equalsIgnoreCase(city)&&
						movieDetails.getMovieId()==max.get().getMovieId()) {
					
					Optional<Integer> findAny = screenShow.stream().filter(i->i==screen.get().getScreenId()).findAny();
					
					if(!findAny.isPresent()) {
						
						screenShow.add( screen.get().getScreenId());
						TheatreByMovieOutDto details = mapper.map(theatre.get(), TheatreByMovieOutDto.class);
						details.setScreenId(screen.get().getScreenId());
						details.setScreenName(screen.get().getScreenName());
						details.setMovieId(movieDetails.getMovieId());
						details.setMovieName(movieDetails.getMovieName());
						tlist.getListOfTheatre().add(details);
						
						
					}
					
				}

			}

		}

		return tlist;

	}

	public TheatreDetailsOutDto getTheatreDetails(int theatreId) throws TheatreNotFoundException {
		Optional<Theatre> theatre = repo.findById(theatreId);
		if (!theatre.isPresent()) {
			throw theatreNotFound.get();
		}

		TheatreDetailsOutDto theatreDetails = convertToTheatreFullDetailsDto.apply(theatre.get());

		List<Screen> screens = sRepo.findByTheatre(theatre.get());

		for (Screen s : screens) {
			ScreenOutDto screenOutDeatils = convertToScreenFullDetailsDto.apply(s);

			List<Show> listOfShows = showRepo.findByScreen(s);
			
			if(!listOfShows.isEmpty()) {
				
				show = listOfShows.stream().max(Comparator.comparing(Show::getLastUpdatedTimestamp)).get();
				String movieuri = "http://MOVIEMS/movie-ms/v1/movie/id/" + show.getMovieId() + "/getdetails";
				ResponseEntity<MovieDetailsDto> movie = client.getForEntity(movieuri, MovieDetailsDto.class);
				MovieDetailsDto movieDetails = movie.getBody();
				screenOutDeatils.setRunningMovie(movieDetails.getMovieName());
				screenOutDeatils.setMovieId(movieDetails.getMovieId());
				screenOutDeatils.setShowId(show.getShowId());
				List<ShowTimeOutDto> showTimeList = stRepo.findByShow(show).stream().map(convertToShowTimingsFullDetailsDto)
						.collect(Collectors.toList());
				screenOutDeatils.getUpcomingShows().addAll(showTimeList);

				theatreDetails.getScreens().add(screenOutDeatils);
				
			}else {
				theatreDetails.getScreens().add(screenOutDeatils);
				
			}

			
			

		}

		return theatreDetails;

	}

}
