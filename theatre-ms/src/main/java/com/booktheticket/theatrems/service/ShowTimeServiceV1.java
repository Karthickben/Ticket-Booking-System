package com.booktheticket.theatrems.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktheticket.theatrems.doamin.entity.ShowTimings;
import com.booktheticket.theatrems.doamin.modal.ApiStatus;
import com.booktheticket.theatrems.doamin.modal.ShowTimeInDto;
import com.booktheticket.theatrems.exceptionhandling.ScreenNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowTimeNotFoundException;
import com.booktheticket.theatrems.exceptionhandling.ShowTimeValidationException;
import com.booktheticket.theatrems.exceptionhandling.TheatreNotFoundException;
import com.booktheticket.theatrems.repository.ScreenRepo;
import com.booktheticket.theatrems.repository.ShowRepo;
import com.booktheticket.theatrems.repository.ShowTimingRepo;
import com.booktheticket.theatrems.repository.TheatreRepo;

@Service
public class ShowTimeServiceV1 {

	@Autowired
	private ShowTimingRepo repo;

	@Autowired
	private TheatreRepo tRepo;

	@Autowired
	private ShowRepo showRepo;

	@Autowired
	private ScreenRepo sRepo;

	@Autowired
	private ApiStatus status;

	@Autowired
	private ModelMapper mapper;

	private Supplier<ScreenNotFoundException> screenNotFound = () -> new ScreenNotFoundException("Screen not found.");

	private Supplier<ShowNotFoundException> showNotFound = () -> new ShowNotFoundException("Show not found.");

	private Supplier<TheatreNotFoundException> theatreNotFound = () -> new TheatreNotFoundException(
			"Theatre not found.");

	private Supplier<ShowTimeNotFoundException> showTimeNotFound = () -> new ShowTimeNotFoundException(
			"show time not found.");

	Function<ShowTimeInDto, ShowTimings> convertShowTimeInDtoToEntity = dto -> mapper.map(dto, ShowTimings.class);

	public ApiStatus addShowTime(int theatreId, int screenId, int showId, ShowTimeInDto showTime)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException, ShowTimeValidationException {

		if (validateShowDetails(theatreId, screenId, showId)) {
			
			System.out.println(theatreId+" "+screenId+" "+showId);
			
			ShowTimings sTime = convertShowTimeInDtoToEntity.apply(showTime);
			sTime.setShow(showRepo.findById(showId).get());
			sTime.setLastUpdatedTimestamp(LocalDateTime.now());
			
			String[] dateDetails = showTime.getDate().split("-");
			LocalDate of = LocalDate.of(Integer.parseInt(dateDetails[0]), Integer.parseInt(dateDetails[1]),
					Integer.parseInt(dateDetails[2]));
			
		   String[] timedetails = showTime.getShowTime().split(":");
		   LocalTime time  = LocalTime.of(Integer.parseInt(timedetails[0]),Integer.parseInt(timedetails[1]));
		   sTime.setShowTime(time);
		   sTime.setDate(of);

		   List<ShowTimings> findByShow = repo.findByShow(showRepo.findById(showId).get());
		   
		   if(!findByShow.isEmpty()) {
			   
				boolean anyMatch = findByShow.stream().anyMatch(e->e.getDate().isEqual(of)&&e.getShowTime().equals(time));
				if(anyMatch) {
					throw new ShowTimeValidationException("Already shows available for this date and time.");
				}
			   
		   }
			
		
		   
			repo.save(sTime);
			status.setStatus(200);
		} else {
			status.setStatus(400);
		}

		return status;
	}
	
	public ApiStatus updateShowTime(int theatreId, int screenId, int showId,int showTimeId, ShowTimeInDto showTime)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException, ShowTimeNotFoundException {
		
		final boolean validateShowDetails = validateShowDetails(theatreId, screenId, showId);
		if (validateShowDetails) {
			repo.findById(showTimeId).orElseThrow(showTimeNotFound);
			ShowTimings sTime = convertShowTimeInDtoToEntity.apply(showTime);
			sTime.setShowTimeId(showTimeId);
			sTime.setShow(showRepo.findById(showId).get());
			sTime.setLastUpdatedTimestamp(LocalDateTime.now());
			String[] dateDetails = showTime.getDate().split("-");
			LocalDate of = LocalDate.of(Integer.parseInt(dateDetails[0]), Integer.parseInt(dateDetails[1]),
					Integer.parseInt(dateDetails[2]));
			
		   String[] timedetails = showTime.getShowTime().split(":");
		   LocalTime time  = LocalTime.of(Integer.parseInt(timedetails[0]),Integer.parseInt(timedetails[1]));
		   sTime.setShowTime(time);
		   sTime.setDate(of);
			repo.save(sTime);
			status.setStatus(200);
		} else {
			status.setStatus(400);
		}

		return status;
	}
	
	public ApiStatus deleteShowTime(int theatreId, int screenId, int showId,int showTimeId)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException, ShowTimeNotFoundException {

		if (validateShowDetails(theatreId, screenId, showId)) {
			repo.findById(showTimeId).orElseThrow(showTimeNotFound);
			repo.deleteById(showTimeId);
			status.setStatus(200);
		} else {
			status.setStatus(400);
		}

		return status;
	}
	
	

	private boolean validateShowDetails(int theatreId, int screenId, int showId)
			throws TheatreNotFoundException, ScreenNotFoundException, ShowNotFoundException {

		tRepo.findById(theatreId).orElseThrow(theatreNotFound);
		sRepo.findById(screenId).orElseThrow(screenNotFound);
		showRepo.findById(showId).orElseThrow(showNotFound);
		return true;

	}
	
	
	
	
}
