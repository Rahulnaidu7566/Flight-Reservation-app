package com.flight_reservation_app_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app_6.entity.USER;

public interface userrepository extends JpaRepository<USER, Long> {

	USER findByEmail(String emailId);

	

}
