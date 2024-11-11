package com.flight_reservation_app_6.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.flight_reservation_app_6.dto.ReservationRequest;
import com.flight_reservation_app_6.entity.Flight;
import com.flight_reservation_app_6.entity.Passanger;
import com.flight_reservation_app_6.entity.Reservation;
import com.flight_reservation_app_6.repository.flightrepository;
import com.flight_reservation_app_6.repository.passangerrepository;
import com.flight_reservation_app_6.repository.reservationrepository;
import com.flight_reservation_app_6.utilities.EmailUtil;
//import com.flight_reservation_app_6.utilities.EmailUtil;
import com.flight_reservation_app_6.utilities.PDFgenerator;

@Service //(IQ) it helps us to define that it the service layer of our application
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private passangerrepository passangerRepo;

	@Autowired
	private flightrepository flightRepo;
		
	@Autowired
	private reservationrepository reservationRepo;
	
	@Autowired
	private PDFgenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
	
		
		Passanger passanger = new Passanger();
		passanger.setFirstName(request.getFirstName());
		passanger.setLastName(request.getLastName());
		passanger.setMiddleName(request.getMiddleName());
		passanger.setEmail(request.getEmail());
		passanger.setPhone(request.getPhone());
		passangerRepo.save(passanger);
	    
		Long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId );
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassanger(passanger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath ="C:\\newcode 2\\flight_reservation_app_6\\tickets\\reservation"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		String toAdress = (passanger.getEmail());
		
		pdfGenerator.generateItinerary(reservation, filePath);
		emailUtil.sendItinerary(toAdress, filePath);
		
		return reservation;
	}
}