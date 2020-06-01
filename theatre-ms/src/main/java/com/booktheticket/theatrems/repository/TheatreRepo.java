package com.booktheticket.theatrems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.theatrems.doamin.entity.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer>{

}
