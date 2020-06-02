package com.booktheticket.bookingms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.bookingms.domain.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

	List<Booking> findByShowTimeId(int showId);

	List<Booking> findBYShowDateBetweenAndTheatrAddress(String fromDate, String toDate, String location);

}
