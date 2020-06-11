package com.booktheticket.bookingms.restcontroller;

import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.booktheticket.bookingms.domain.model.ApiStatus;
import com.booktheticket.bookingms.domain.model.BookingInDto;
import com.booktheticket.bookingms.domain.model.BookingReportDto;
import com.booktheticket.bookingms.domain.model.SeatingChartOutDto;
import com.booktheticket.bookingms.domain.model.TicketDto;
import com.booktheticket.bookingms.exceptionhandling.BookingNotFound;
import com.booktheticket.bookingms.exceptionhandling.BookingValidationException;
import com.booktheticket.bookingms.exceptionhandling.ScreenNotFound;
import com.booktheticket.bookingms.exceptionhandling.TheatreNotFound;
import com.booktheticket.bookingms.service.BookingService1;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingRestController {

	@Autowired
	private BookingService1 service;

	private Function<BindingResult, String> getValidationErrorMessage = error -> error.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

	private Function<String, BookingValidationException> bookingValidationException = message -> new BookingValidationException(
			message);

	@PostMapping
	public ApiStatus bookTheTicket(@Valid @RequestBody BookingInDto bookingDetails, BindingResult results)
			throws BookingValidationException {
		if (results.hasErrors()) {
			throw bookingValidationException.apply(getValidationErrorMessage.apply(results));
		}

		return service.bookTheTicket(bookingDetails);
	}

	@PutMapping("/{bookingId}/cancel")
	public ApiStatus canceTheTicket(@PathVariable("bookingId") int bookingId) throws BookingNotFound {
		return service.canceTheTicket(bookingId);

	}

	@GetMapping("/screen/{screenId}/showTime/{showTimeId}/genseatingchart")
	public SeatingChartOutDto getSeatingChart(@PathVariable("screenId") int screenId,
			@PathVariable("showTimeId") int showTimeId) throws ScreenNotFound {
		System.out.println("Inside Gen Seating chart1");
		return service.getSeatingChart(screenId, showTimeId);

	}

	@GetMapping("/{bookingId}/genticket")
	public TicketDto generateTicket(@PathVariable("bookingId") int bookingId)
			throws BookingNotFound, ScreenNotFound, TheatreNotFound {
		return service.genTicket(bookingId);
	}
	
	@GetMapping("/reports/{fromDate}/{toDate}/genreport")
	public BookingReportDto genReports(@PathVariable("fromDate") String fromDate, 
			@PathVariable("toDate") String toDate)
	
			throws BookingNotFound, ScreenNotFound, TheatreNotFound {
		
		return service.genReports(fromDate, toDate);
	}
	
	@GetMapping("/report/user/{user}/genreport")
	public BookingReportDto genReportsForTheGivenUser(@PathVariable("user") String user )
			throws BookingNotFound, ScreenNotFound, TheatreNotFound {
		System.out.println("inside Booking by user Controller");
		
		return service.genReportsByUser(user);
		
	
	}
	

}
