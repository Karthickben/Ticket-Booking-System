package com.booktheticket.bookingms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booktheticket.bookingms.domain.entity.Booking;
import com.booktheticket.bookingms.domain.model.ApiStatus;
import com.booktheticket.bookingms.domain.model.BookingInDto;
import com.booktheticket.bookingms.domain.model.BookingReportDto;
import com.booktheticket.bookingms.domain.model.ScreenSeatingDetailsOut;
import com.booktheticket.bookingms.domain.model.SeatingChartOutDto;
import com.booktheticket.bookingms.domain.model.SeatingoutDto;
import com.booktheticket.bookingms.domain.model.TheatreDetailsOutDto;
import com.booktheticket.bookingms.domain.model.TicketDto;
import com.booktheticket.bookingms.exceptionhandling.BookingNotFound;
import com.booktheticket.bookingms.exceptionhandling.ScreenNotFound;
import com.booktheticket.bookingms.exceptionhandling.TheatreNotFound;
import com.booktheticket.bookingms.repo.BookingRepo;

@Service
public class BookingService1 {

	@Autowired
	private BookingRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private RestTemplate client;

	@Autowired
	private ApiStatus status;

	private Function<BookingInDto, Booking> convertBookingInDtoToentity = dto -> mapper.map(dto, Booking.class);

	public ApiStatus bookTheTicket(BookingInDto bookingDetails) {

		System.out.println(bookingDetails);
		Booking details = convertBookingInDtoToentity.apply(bookingDetails);
		System.out.println(details);
		details.setLastUpdatedTimestamp(LocalDateTime.now());
		details.setTicketStatus("Confirmed");
		double totalPrice = details.getNumberOfSeatsBooked() * details.getTicketPrice();
		details.setTotalPrice(totalPrice);

		String[] dateDetails = bookingDetails.getShowDate().split("-");
		LocalDate date = LocalDate.of(Integer.parseInt(dateDetails[0]), Integer.parseInt(dateDetails[1]),
				Integer.parseInt(dateDetails[2]));

		String[] timedetails = bookingDetails.getShowTime().split(":");
		LocalTime time = LocalTime.of(Integer.parseInt(timedetails[0]), Integer.parseInt(timedetails[1]));
		details.setShowDate(date);
		details.setShowTime(time);

		repo.save(details);
		status.setStatus(200);
		return status;
	}

	public ApiStatus canceTheTicket(int bookingId) throws BookingNotFound {

		Optional<Booking> details = repo.findById(bookingId);
		if (!details.isPresent()) {
			throw new BookingNotFound("Booking not found.");
		}
		Booking booking = details.get();
		booking.setTicketStatus("Cancelled");
		repo.save(booking);
		status.setStatus(200);
		return status;

	}

	public SeatingChartOutDto getSeatingChart(int screenId, int showTimeId) throws ScreenNotFound {

		ResponseEntity<ScreenSeatingDetailsOut> seatingDetails = getScreenDetails(screenId);

		List<Booking> st = repo.findByShowTimeId(showTimeId);
		String seatNumbers = st.stream().filter(booking -> booking.getTicketStatus().equals("Confirmed"))
				.map(Booking::getSeatNumbers).collect(Collectors.joining(","));

		String[] seats = seatNumbers.split(",");
		List<String> seatList = Arrays.asList(seats);

		List<SeatingoutDto> lisLtOfSeats = new ArrayList<>();
		int seatNumbering = 'A' + seatingDetails.getBody().getNoOfSeatingRows();

		for (char alpha = 'A'; alpha <= seatNumbering; alpha++) {
			for (int i = 1; i <= seatingDetails.getBody().getNoOfSeatingColumns(); i++) {
				String seatNum = alpha + "" + i;
				boolean anyMatch = seatList.stream().anyMatch(s -> s.equals(seatNum));
				System.out.println(seatNum);
				if (!anyMatch) {
					lisLtOfSeats.add(new SeatingoutDto(seatNum, false));
				}else {
					lisLtOfSeats.add(new SeatingoutDto(seatNum, true));
				}

			}

		}

		SeatingChartOutDto sChart = new SeatingChartOutDto();
		sChart.setSeatingChart(lisLtOfSeats);
		return sChart;

	}

	public TicketDto genTicket(int bookingId) throws BookingNotFound, ScreenNotFound, TheatreNotFound {

		Optional<Booking> bookingDetails = repo.findById(bookingId);

		if (!bookingDetails.isPresent()) {
			throw new BookingNotFound("Booking not found");
		}

		Booking booking = bookingDetails.get();

		ResponseEntity<ScreenSeatingDetailsOut> screenDetails = getScreenDetails(bookingDetails.get().getScreenId());
		TheatreDetailsOutDto theatreDetails = getTheatreDetails(bookingDetails.get().getTheatreId());

		TicketDto ticket = new TicketDto();
		ticket.setScreenName(screenDetails.getBody().getScreenName());
		ticket.setSeatNumbers(booking.getSeatNumbers());
		ticket.setShowDate(booking.getShowDate().toString());
		ticket.setShowTime(booking.getShowTime().toString());
		ticket.setStatus(booking.getTicketStatus());
		ticket.setTheatrAddress(theatreDetails.getCity());
		ticket.setTheatreName(theatreDetails.getTheatreName());
		ticket.setTicketPrice(booking.getTicketPrice());
		ticket.setTotalPrice(booking.getTotalPrice());
		ticket.setUserEmailId(booking.getUserId());
		ticket.setTotalSeatsBoooked(booking.getNumberOfSeatsBooked());

		return ticket;

	}

	private ResponseEntity<ScreenSeatingDetailsOut> getScreenDetails(int screenId) throws ScreenNotFound {

		String url = "http://TheatreMs/theatre-ms/v1/theatre-screen/screen/" + screenId + "/getSeatDetails";
		ResponseEntity<ScreenSeatingDetailsOut> seatingDetails = client.getForEntity(url,
				ScreenSeatingDetailsOut.class);

		HttpStatus statusCode = seatingDetails.getStatusCode();

		System.out.println("StatusCode: " + statusCode);

		if (HttpStatus.OK != statusCode) {
			throw new ScreenNotFound("Screen not found");
		}
		return seatingDetails;
	}

	private TheatreDetailsOutDto getTheatreDetails(int theatreId) throws TheatreNotFound {

		String url = "http://TheatreMs/theatre-ms/v1/theatre/" + theatreId + "/getdetails";
		ResponseEntity<TheatreDetailsOutDto> theatreDetails = client.getForEntity(url, TheatreDetailsOutDto.class);
		if (HttpStatus.OK != theatreDetails.getStatusCode()) {
			throw new TheatreNotFound("Theatre not found");
		}

		return theatreDetails.getBody();

	}

	public BookingReportDto genReports(String location, String fromDate, String toDate)
			throws BookingNotFound, ScreenNotFound, TheatreNotFound {
		
		String[] from = fromDate.split("-");
		LocalDate fDate = LocalDate.of(Integer.parseInt(from[0]), Integer.parseInt(from[1]),
				Integer.parseInt(from[2]));
		
		String[] to = toDate.split("-");
		LocalDate tDate = LocalDate.of(Integer.parseInt(to[0]), Integer.parseInt(to[1]),
				Integer.parseInt(to[2]));

		List<Booking> listOfBooking = repo.findByShowDateBetween(fDate, tDate);

		List<TicketDto> listOfBookingDetails = new ArrayList<>();

		for (Booking book : listOfBooking) {
			TicketDto genTicket = genTicket(book.getBookingId());
			if(genTicket.getTheatrAddress().equalsIgnoreCase(location)) {
				listOfBookingDetails.add(genTicket);
			}
		}

		BookingReportDto report = new BookingReportDto();
		report.setListOfBookingDetails(listOfBookingDetails);
		return report;
	}

}
