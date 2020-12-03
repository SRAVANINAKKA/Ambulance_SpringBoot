package com.cg.Ambulance.respository;

import org.springframework.data.repository.CrudRepository;

import com.cg.Ambulance.domain.Ambulance;

public interface AmbulanceRepository extends CrudRepository<Ambulance, Long>{
	 Ambulance findByBookingIdentifier(String bookingIdentifier);	
	 Iterable<Ambulance> findAll();
}
