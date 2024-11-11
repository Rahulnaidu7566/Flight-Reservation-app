package com.flight_reservation_app_6.utilities;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

	import java.io.File;

	@Component
	public class EmailUtil  {
		
	    @Autowired
	    private JavaMailSender sender;

	    public void sendItinerary(String toAddress, String filePath) {
	    		System.out.println(filePath);
	        
	    		MimeMessage message =  sender.createMimeMessage();

//	        MimeMessageHelper messageHelper = null;
	        try {
	        	MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);

	            messageHelper.setTo(toAddress);
	            messageHelper.setSubject("Itinerary Of Flight");
	            messageHelper.setText("your ticket is confirmed from flight number");
	            messageHelper.addAttachment("Itinerary", new File(filePath));
	            sender.send(message);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	}


