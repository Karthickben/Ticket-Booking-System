package com.booktheticket.userms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktheticket.userms.domain.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
