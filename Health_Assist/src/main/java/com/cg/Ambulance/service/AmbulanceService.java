package com.cg.Ambulance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.exception.BookingIDException;
import com.cg.Ambulance.respository.AmbulanceRepository;

@Service

public class AmbulanceService {
	@Autowired
	private AmbulanceRepository ambulanceRepository;

	public Ambulance saveOrUpdate(Ambulance ambulance) {
		try {
			ambulance.setBookingIdentifier(ambulance.getBookingIdentifier().toUpperCase());
			return ambulanceRepository.save(ambulance);
		}
		catch (Exception e) {
			throw new BookingIDException("BookingIdentifier " + ambulance.getBookingIdentifier() + " already available");
		}
	}
		public Ambulance findAmbulanceByBookingIdentifier(String bookingIdentifier) {
			Ambulance ambulance = ambulanceRepository.findByBookingIdentifier(bookingIdentifier.toUpperCase());
			if (ambulance == null) {
				throw new BookingIDException("BookingIdentifier " + bookingIdentifier + " not available");
			
			}
			return ambulance;

		
	}
		public Iterable<Ambulance> findAllBookings(){
			return ambulanceRepository.findAll();
		}
}
