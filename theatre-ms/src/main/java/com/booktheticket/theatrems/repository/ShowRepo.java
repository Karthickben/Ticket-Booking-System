package com.booktheticket.theatrems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.theatrems.doamin.entity.Screen;
import com.booktheticket.theatrems.doamin.entity.Show;

@Repository
public interface ShowRepo extends JpaRepository<Show, Integer> {

	List<Show> findByScreen(Screen s);

	List<Show> findByMovieId(int movieId);

}
