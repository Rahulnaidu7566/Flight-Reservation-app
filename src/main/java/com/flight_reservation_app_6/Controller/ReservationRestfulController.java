package com.flight_reservation_app_6.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app_6.dto.ReservationUpdateRequest;
import com.flight_reservation_app_6.entity.Reservation;
import com.flight_reservation_app_6.repository.reservationrepository;

@RestController // it converts java object to json object back to java code
public class ReservationRestfulController {

	@Autowired
	private reservationrepository reservationRepo;

	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;

	}

	@RequestMapping("/reservation")
		public Reservation updateResevation(@RequestBody ReservationUpdateRequest request) {//it binds the json object datawith java class object
         Optional<Reservation> findById = reservationRepo.findById(request.getId());
	Reservation reservation = findById.get();
	reservation.setCheckedIn(request.isCheckedIn());
	reservation.setNumberOfBags(request.getNumberOfBags());
	return reservationRepo.save(reservation);
	
		    
}
}