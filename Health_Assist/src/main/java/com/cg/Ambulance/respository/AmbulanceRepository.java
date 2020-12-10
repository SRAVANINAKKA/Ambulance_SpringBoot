package com.cg.Ambulance.respository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.Ambulance.domain.Ambulance;
/**
 * creating AmbulanceRespository Interface which extends crudRespository which provides CRUD operations
 *
 */
@Repository
public interface AmbulanceRepository extends CrudRepository<Ambulance, Long>{
	public  Ambulance findByBookingIdentifier(String bookingIdentifier);	
	 public Iterable<Ambulance> findAll();
	 
}
