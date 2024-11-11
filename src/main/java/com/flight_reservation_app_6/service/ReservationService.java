package com.flight_reservation_app_6.service;

import com.flight_reservation_app_6.dto.ReservationRequest;
import com.flight_reservation_app_6.entity.Reservation;

public interface ReservationService {
   
	Reservation bookFlight(ReservationRequest request);


}
