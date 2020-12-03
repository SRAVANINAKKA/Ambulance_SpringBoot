package com.cg.Ambulance.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.service.AmbulanceService;

@RestController
@RequestMapping("/api/ambulances")
public class AmbulanceController {
	@Autowired
	private AmbulanceService ambulanceService;

	@PostMapping("")
	public ResponseEntity<Ambulance> createNewProject(@Valid @RequestBody Ambulance ambulance) {
		Ambulance newAmbulance = ambulanceService.saveOrUpdate(ambulance);
		return new ResponseEntity<Ambulance>(newAmbulance, HttpStatus.CREATED);
	}

}
