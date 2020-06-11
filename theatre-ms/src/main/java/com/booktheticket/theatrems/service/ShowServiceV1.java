package com.booktheticket.theatrems.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booktheticket.theatrems.doamin.entity.Screen;
import com.booktheticket.theatrems.doamin.entity.Show;
import com.booktheticket.theatrems.doamin.entity.ShowTimings;
import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.MovieDetailsDto;
import com.booktheticket.theatrems.doamin.modal.ShowInDto;
import com.booktheticket.theatrems.exceptionhandling.MovieNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScheduledShowsFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.repository.ScreenRepo;
import com.booktheticket.theatrems.repository.ShowRepo;
import com.booktheticket.theatrems.repository.ShowTimingRepo;
import com.booktheticket.theatrems.repository.TheatreRepo;

@Service
public class ShowServiceV1 {

	@Autowired
	private ShowRepo repo;
	@Autowired
	private TheatreRepo tRepo;
	@Autowired
	private ScreenRepo sRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ShowTimingRepo showRepo;

	@Autowired
	private RestTemplate client;
	@Autowired
	private ApiStatus status;

	private Function<ShowInDto, Show> convertShowInDtoToEntity = dto -> mapper.map(dto, Show.class);
	private Supplier<TheatreNotFoundException> theatreNotFound = () -> new TheatreNotFoundException(
			"Theatre not found.");
	private Supplier<ScreenNotFoundException> screenNotFound = () -> new ScreenNotFoundException("Screen not found.");

	private Supplier<ShowNotFoundException> showNotFound = () -> new ShowNotFoundException("Show not found.");

	public ApiStatus addShow(int theareId, int screenId, ShowInDto show)
			throws TheatreNotFoundException, ScreenNotFoundException, MovieNotFoundException, ScheduledShowsFoundException {
		
		

		if (validateShowDetials(theareId, screenId, show)) {
			
			List<Show> findByScreen = repo.findByScreen(sRepo.findById(screenId).get());
			if(!findByScreen.isEmpty()) {
				for(Show sh:findByScreen) {
					if(sh.getScreen().getScreenId()==screenId) {
						List<ShowTimings> findByShow = showRepo.findByShow(sh);
						if(!findByShow.isEmpty()) {
							for(ShowTimings sts: findByShow) {
								if(sts.getDate().isAfter(LocalDate.now().minusDays(1))) {
									throw new ScheduledShowsFoundException("Scheduled Shows are available for this"
											+ " screen.");
									
								}
							}
							
						}
					}
					
				}
				
			}
			
			Optional<Screen> screen = sRepo.findById(screenId);
			Show showDetails = convertShowInDtoToEntity.apply(show);
			showDetails.setLastUpdatedTimestamp(LocalDateTime.now());
			showDetails.setScreen(screen.get());
			String[] dateDetails = show.getEffectiveDate().split("-");
			LocalDate of = LocalDate.of(Integer.parseInt(dateDetails[0]), Integer.parseInt(dateDetails[1]),
					Integer.parseInt(dateDetails[2]));
			showDetails.setEffectiveDate(of);

			repo.save(showDetails);
			status.setStatus(200);
		} else {
			status.setStatus(400);
		}

		return status;

	}

	public ApiStatus updateShow(int theareId, int screenId, int showId, ShowInDto show)
			throws TheatreNotFoundException, ScreenNotFoundException, MovieNotFoundException, ShowNotFoundException {

		if (validateShowDetials(theareId, screenId, show)) {
			repo.findById(showId).orElseThrow(showNotFound);
			Optional<Screen> screen = sRepo.findById(screenId);
			Show showDetails = convertShowInDtoToEntity.apply(show);
			showDetails.setScreen(screen.get());
			showDetails.setShowId(showId);
			showDetails.setLastUpdatedTimestamp(LocalDateTime.now());
			showDetails.setScreen(screen.get());
			String[] dateDetails = show.getEffectiveDate().split("-");
			LocalDate of = LocalDate.of(Integer.parseInt(dateDetails[0]), Integer.parseInt(dateDetails[1]),
					Integer.parseInt(dateDetails[2]));
			showDetails.setEffectiveDate(of);
			repo.save(showDetails);
			status.setStatus(200);
		} else {
			status.setStatus(400);
		}

		return status;

	}

	public ApiStatus deleteTheShow(int showId, int theareId, int screenId)
			throws ShowNotFoundException, TheatreNotFoundException, ScreenNotFoundException {

		tRepo.findById(theareId).orElseThrow(theatreNotFound);
		sRepo.findById(screenId).orElseThrow(screenNotFound);
		repo.findById(showId).orElseThrow(showNotFound);
		System.out.println(showId);
		repo.deleteById(showId);
		status.setStatus(200);
		return status;
	}

	private boolean validateShowDetials(int theareId, int screenId, ShowInDto show)
			throws TheatreNotFoundException, ScreenNotFoundException, MovieNotFoundException {

		tRepo.findById(theareId).orElseThrow(theatreNotFound);
		sRepo.findById(screenId).orElseThrow(screenNotFound);
		String movieuri = "http://MOVIEMS/movie-ms/v1/movie/id/" + show.getMovieId() + "/getdetails";
		ResponseEntity<MovieDetailsDto> movie = client.getForEntity(movieuri, MovieDetailsDto.class);
		
		HttpStatus statusCode = movie.getStatusCode();
		System.out.println(statusCode);
		if (HttpStatus.OK!=statusCode) {
			throw new MovieNotFoundException("Movie not found");
		}

		return true;

	}

	
	public boolean isMovieIsAvailble(int movieId) {
		System.out.println(movieId);
	
		List<Show> findByMovieId = repo.findByMovieId(movieId);
		
		System.out.println(findByMovieId);
		
		if(findByMovieId.isEmpty()) {
			return true;
		}
		
		return false;
	}
}


