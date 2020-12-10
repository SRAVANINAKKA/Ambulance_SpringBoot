package com.cg.Ambulance.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.service.AmbulanceService;
import com.cg.Ambulance.service.MapValidationErrorService;
/**
 * creating a class AmbulanceController which controls all the services related to Ambulance
 *
 */
@RestController
@RequestMapping("/api/ambulances")
public class AmbulanceController {
	
	/**
	 * creating an instance for ambulanceService and autowiring is used to instantiate the object
	 */
	@Autowired
	private AmbulanceService ambulanceService;
	/**
	 * creating MapValidationService instance to instantiate mapValidationError to show fields which are given blank
	 * by returning errorMap
	 */
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Ambulance ambulance, BindingResult result) {
		
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Ambulance newAmbulance = ambulanceService.save(ambulance);
		return new ResponseEntity<Ambulance>(newAmbulance, HttpStatus.OK);
	}
	@GetMapping("/{bookingIdentifier}")
	public Ambulance getAmbulanceByBookingIdentifier(@PathVariable String bookingIdentifier){
		return  ambulanceService.findAmbulanceByBookingIdentifier(bookingIdentifier);
	}
	@GetMapping("/all")
	public Iterable<Ambulance> viewAllBookings(){
		return ambulanceService.viewAllBookings();
	}
	@PatchMapping("/result/{bookingIdentifier}")
	public ResponseEntity<?> updateByBookingResult(@PathVariable String bookingIdentifier, @RequestBody  String bookingResult){
		Ambulance ambulanceobj = ambulanceService.updateByBookingResult(bookingIdentifier, bookingResult);
		return new ResponseEntity<Ambulance>(ambulanceobj, HttpStatus.CREATED);
	}
}
