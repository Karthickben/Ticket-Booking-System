package com.booktheticket.theatrems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.theatrems.doamin.entity.Screen;
import com.booktheticket.theatrems.doamin.entity.Theatre;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer> {

	List<Screen> findByTheatre(Theatre theatre);
	
	

}
