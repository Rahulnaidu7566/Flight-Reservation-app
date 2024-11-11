package com.flight_reservation_app_6.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.flight_reservation_app_6.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFgenerator {


	public void generateItinerary(Reservation reservation, String filePath) {
	  Document document = new Document();
	  try {
		  PdfWriter.getInstance(document, new FileOutputStream(filePath));
		  
		  document.open();
		  document.add(generateTable(reservation));
		  document.close();
	  } catch (FileNotFoundException | DocumentException e) {
		  e.printStackTrace();
	  }
	
	}
	private PdfPTable generateTable(Reservation reservation) {
		
		PdfPTable table = new PdfPTable(2);//creates a column
		PdfPCell cell; //reference variable of cell
		
		cell= new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);//two column will merge
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		//inside reservation its one to one mapping getflight() it gives flight object address using object address we are calling city
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Operating Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell = new PdfPCell (new Phrase("Passenger Details"));
//		cell.setColspan(2);
//		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassanger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassanger().getLastName());
		
		table.addCell("Middle Name");
		table.addCell(reservation.getPassanger().getMiddleName());
		
		table.addCell("email");
		table.addCell(reservation.getPassanger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassanger().getPhone());
		
		return table;
}
	}

	