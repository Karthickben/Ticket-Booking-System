package com.booktheticket.moviems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.moviems.domain.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{

	List<Movie> findAllByMovieName(String movieName);

	

}
