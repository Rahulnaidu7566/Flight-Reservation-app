package com.flight_reservation_app_6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app_6.dto.ReservationRequest;
import com.flight_reservation_app_6.entity.Reservation;
import com.flight_reservation_app_6.service.ReservationService;


@Controller
public class reservationController {
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());	
		return"confirm";
		
	}
}
