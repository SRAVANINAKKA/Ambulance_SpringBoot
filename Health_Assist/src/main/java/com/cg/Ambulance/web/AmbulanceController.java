package com.cg.Ambulance.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.service.AmbulanceService;
import com.cg.Ambulance.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/ambulances")
public class AmbulanceController {
	@Autowired
	private AmbulanceService ambulanceService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Ambulance ambulance, BindingResult result) {
		
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Ambulance newAmbulance = ambulanceService.saveOrUpdate(ambulance);
		return new ResponseEntity<Ambulance>(newAmbulance, HttpStatus.CREATED);
	}
	@GetMapping("/{bookingIdentifier}")
	public ResponseEntity<?> getAmbulanceByBookingIdentifier(@PathVariable String bookingIdentifier){
		return new ResponseEntity<Ambulance>( ambulanceService.findAmbulanceByBookingIdentifier(bookingIdentifier),HttpStatus.OK);
	}
	@ViewMapping("/all")
	public Iterable<Ambulance> getAllBookings(){
		return ambulanceService.findAllBookings();
	}
}
