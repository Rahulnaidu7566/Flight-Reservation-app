package com.flight_reservation_app_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app_6.entity.Reservation;

public interface reservationrepository extends JpaRepository<Reservation, Long> {
      
}
