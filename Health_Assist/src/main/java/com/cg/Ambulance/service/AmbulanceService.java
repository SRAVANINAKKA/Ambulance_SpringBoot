package com.cg.Ambulance.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.exception.BookingIDException;
import com.cg.Ambulance.respository.AmbulanceRepository;
/**
 * creating AmbulanceService class which provides different services for ambulance class
 *
 */
@Service

public class AmbulanceService {
	/**
	 * declaring ambulanceRepository instance and autowiring helps to instantiate the object
	 */
	@Autowired
	private AmbulanceRepository ambulanceRepository;

	/**
	 * creating save method to save the details of ambulance into the ambulance table
	 * @param ambulance
	 * @return
	 */
	public Ambulance save(Ambulance ambulance) {
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
	
	public Iterable<Ambulance> viewAllBookings(){
			return ambulanceRepository.findAll();
		}
	
	public Ambulance updateByBookingResult(String bookingIdentifier, String bookingResult){
		Ambulance ambulance = ambulanceRepository.findByBookingIdentifier(bookingIdentifier.toUpperCase());
		if (ambulance == null) {
			throw new BookingIDException("BookingIdentifier with " + bookingIdentifier + " does not exist to update");
            }
	    ambulance.setBookingResult(bookingResult);
			return ambulanceRepository.save(ambulance);
		    }
		
}
