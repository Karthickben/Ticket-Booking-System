package com.booktheticket.theatrems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.theatrems.doamin.entity.Show;
import com.booktheticket.theatrems.doamin.entity.ShowTimings;

@Repository
public interface ShowTimingRepo extends JpaRepository<ShowTimings, Integer> {

	List<ShowTimings> findByShow(Show show);

}

