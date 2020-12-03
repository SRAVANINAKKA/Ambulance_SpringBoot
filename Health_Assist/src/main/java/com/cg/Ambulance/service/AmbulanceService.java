package com.cg.Ambulance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.respository.AmbulanceRepository;

@Service

public class AmbulanceService {
	@Autowired
	private AmbulanceRepository ambulanceRepository;

	public Ambulance saveOrUpdate(Ambulance ambulance) {
		//TODO Service Logic on Project
		return ambulanceRepository.save(ambulance);
	}
}
