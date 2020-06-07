package com.booktheticket.theatrems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.theatrems.doamin.entity.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer>{

	Optional<Theatre> findByTheatreName(String theatreName);

	List<Theatre> findByTheatreNameAndArea(String theatreName, String area);

	

}
