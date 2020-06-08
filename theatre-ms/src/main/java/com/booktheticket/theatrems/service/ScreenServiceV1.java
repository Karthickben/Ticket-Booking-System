package com.booktheticket.theatrems.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktheticket.theatrems.doamin.entity.Screen;
import com.booktheticket.theatrems.doamin.entity.Show;
import com.booktheticket.theatrems.doamin.entity.ShowTimings;
import com.booktheticket.theatrems.doamin.entity.Theatre;
import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.ScreenInDto;
import com.booktheticket.theatrems.doamin.modal.ScreenSeatingDetailsOut;
import com.booktheticket.theatrems.exceptionhandling.ScheduledShowsFoundException;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowsFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.repository.ScreenRepo;
import com.booktheticket.theatrems.repository.ShowRepo;
import com.booktheticket.theatrems.repository.ShowTimingRepo;
import com.booktheticket.theatrems.repository.TheatreRepo;

@Service
public class ScreenServiceV1 {

	@Autowired
	private ScreenRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private TheatreRepo tRepo;
	@Autowired
	private ApiStatus status;
	
	@Autowired
	private ShowRepo sRepo;
	
	@Autowired
	private ShowTimingRepo showRepo;
	
	private Supplier<LocalDateTime> currentTimeStamp = () -> LocalDateTime.now();

	private Function<ScreenInDto, Screen> convertScreenInDtoToentity = (dto) -> mapper.map(dto, Screen.class);

	private Supplier<TheatreNotFoundException> theatreNotFound = () -> new TheatreNotFoundException(
			"Theatre not found.");

	private Supplier<ScreenNotFoundException> screenNotFound = () -> new ScreenNotFoundException("Screen not found.");

	public ApiStatus addScreen(ScreenInDto screen, int theatreId) throws TheatreNotFoundException {
		Optional<Theatre> theatre = tRepo.findById(theatreId);
		if(!theatre.isPresent()) {
			throw theatreNotFound.get();
		}

		Screen screen1 = convertScreenInDtoToentity.apply(screen);
		screen1.setLastUpdatedTimestamp(currentTimeStamp.get());
		screen1.setTheatre(theatre.get());
		repo.save(screen1);
		status.setStatus(200);
		return  status;
	}

	public ApiStatus updateScreen(ScreenInDto screen, int screenId, int theatreId)
			throws TheatreNotFoundException, ScreenNotFoundException, ScheduledShowsFoundException {
		Optional<Theatre> theatre = tRepo.findById(theatreId);

		if (theatre.isPresent()) {
			Optional<Screen> screen1 = repo.findById(screenId);
			if (!screen1.isPresent()) {
				throw theatreNotFound.get();
			}
			List<Show> findByScreen = sRepo.findByScreen(screen1.get());
			if(!findByScreen.isEmpty()) {
				for(Show sh:findByScreen) {
					List<ShowTimings> findByShow = showRepo.findByShow(sh);
					if(!findByShow.isEmpty()) {
						for(ShowTimings sts: findByShow) {
							if(sts.getDate().isAfter(LocalDate.now().minusDays(1))) {
								throw new ScheduledShowsFoundException("Scheduled Shows are availble for this"
										+ "screen.");
								
							}
						}
						
					}
				}
				
			}
		} else {
			throw screenNotFound.get();
		}

		
		
		Screen screen1 = convertScreenInDtoToentity.apply(screen);
		screen1.setLastUpdatedTimestamp(currentTimeStamp.get());
		screen1.setScreenId(screenId);
		screen1.setTheatre(theatre.get());
		repo.save(screen1);
		status.setStatus(200);
		return status;

	}

	public ApiStatus deleteSCreen(int screenId, int theatreId) throws TheatreNotFoundException, ScreenNotFoundException, ShowsFoundException, ScheduledShowsFoundException {
		Optional<Theatre> theatre = tRepo.findById(theatreId);

		if (theatre.isPresent()) {
			Optional<Screen> screen1 = repo.findById(screenId);
			if (!screen1.isPresent()) {
				throw theatreNotFound.get();
			}
			List<Show> findByScreen = sRepo.findByScreen(screen1.get());
			if(!findByScreen.isEmpty()) {
				for(Show sh:findByScreen) {
					List<ShowTimings> findByShow = showRepo.findByShow(sh);
					if(!findByShow.isEmpty()) {
						for(ShowTimings sts: findByShow) {
							if(sts.getDate().isAfter(LocalDate.now().minusDays(1))) {
								throw new ScheduledShowsFoundException("Scheduled Shows are availble for this"
										+ "screen.");
								
							}
						}
						
					}
				}
				
			}
			
		} else {
			throw screenNotFound.get();
		}

		
		
		repo.deleteById(screenId);
		status.setStatus(200);
		return status;
	}
	
	public ScreenSeatingDetailsOut getSeatingDetails(int screenId) throws ScreenNotFoundException, ShowsFoundException {
		
		System.out.println(screenId);
		System.out.println("inside seating service");
		
		Optional<Screen> screen = repo.findById(screenId);
		if(!screen.isPresent()) {
			throw screenNotFound.get();
		}
		
		
		return mapper.map(screen.get(), ScreenSeatingDetailsOut.class);
		
		
		
		
	}

}
