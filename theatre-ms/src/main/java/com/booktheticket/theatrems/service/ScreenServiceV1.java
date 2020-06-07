package com.booktheticket.theatrems.service;

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
import com.booktheticket.theatrems.doamin.entity.Theatre;
import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.ScreenInDto;
import com.booktheticket.theatrems.doamin.modal.ScreenSeatingDetailsOut;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowsFoundException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.repository.ScreenRepo;
import com.booktheticket.theatrems.repository.ShowRepo;
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
			throws TheatreNotFoundException, ScreenNotFoundException {
		Optional<Theatre> theatre = tRepo.findById(theatreId);

		if (theatre.isPresent()) {
			Optional<Screen> screen1 = repo.findById(screenId);
			if (!screen1.isPresent()) {
				throw theatreNotFound.get();
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

	public ApiStatus deleteSCreen(int screenId, int theatreId) throws TheatreNotFoundException, ScreenNotFoundException {
		Optional<Theatre> theatre = tRepo.findById(theatreId);

		if (theatre.isPresent()) {
			Optional<Screen> screen1 = repo.findById(screenId);
			if (!screen1.isPresent()) {
				throw theatreNotFound.get();
			}
		} else {
			throw screenNotFound.get();
		}

		repo.deleteById(screenId);
		status.setStatus(200);
		return status;
	}
	
	public ScreenSeatingDetailsOut getSeatingDetails(int screenId) throws ScreenNotFoundException, ShowsFoundException {
		
		Optional<Screen> screen = repo.findById(screenId);
		if(!screen.isPresent()) {
			throw screenNotFound.get();
		}
		
		List<Show> findByScreen = sRepo.findByScreen(screen.get());
		if(!findByScreen.isEmpty()) {
			throw new ShowsFoundException("Show exsists for this screen.");
		}
		
		return mapper.map(screen.get(), ScreenSeatingDetailsOut.class);
		
		
		
		
	}

}
