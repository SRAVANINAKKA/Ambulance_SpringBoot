package com.cg.Ambulance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.respository.AmbulanceRepository;
import com.cg.Ambulance.service.AmbulanceService;

@ExtendWith(MockitoExtension.class)
public class AmbulanceServiceTest {
	@Mock
	private AmbulanceRepository ambulanceRepository;
	@InjectMocks
	private AmbulanceService ambulanceService;

	@Test
	public void test_Save_GivenAmbulance() {
		Ambulance newambulance = new Ambulance(101, "AE12", "12345","driver1", "user1", "Delhi", null);
		when(ambulanceRepository.save(Mockito.any(Ambulance.class))).thenReturn(newambulance);
		Ambulance ambulanceFound = ambulanceService.save(newambulance);
		assertEquals("12345", ambulanceFound.getAmbulance_Number());
	}
	@Test
	public void test_viewAllBookings_ReturnsListOfAmbulance() {
		List<Ambulance> list = new LinkedList<>();
		list.add(new Ambulance(101,"AE12","1234","driver1","user1","Delhi",null));
		list.add(new Ambulance(102,"AE13","12345","driver2","user2","Andhara",null));
		list.add(new Ambulance(103,"AE14","12346","driver3","user3","Nuzvid",null));
		when(ambulanceRepository.findAll()).thenReturn(list);
		Iterable<Ambulance> result = ambulanceService.viewAllBookings();
		assertEquals(list.size(), ((List<Ambulance>) result).size());
	}
		@Test
		public void test_getAmbulanceByBookingIdentifier() {
			Ambulance ambulance = new Ambulance(101,"AE12","1234","driver1","user1","Delhi",null);
			
			Mockito.when(ambulanceRepository.findByBookingIdentifier("AE12")).thenReturn(ambulance).thenReturn(null);
			Ambulance newambulance = ambulanceService.findAmbulanceByBookingIdentifier("AE12");
			assertThat(newambulance);
		}
		@Test
		public void test_updateByBookingResult_ReturnAmbulanceObject() {
			Ambulance ambulance = new Ambulance(101,"AE12","1234","driver1","user1","Delhi",null);
			when(ambulanceRepository.findByBookingIdentifier("AE12")).thenReturn(ambulance);
			when(ambulanceRepository.save(Mockito.any(Ambulance.class))).thenReturn(ambulance);
			Ambulance newambulance = ambulanceService.updateByBookingResult("AE12", "Accepted");
			assertEquals("Accepted", newambulance.getBookingResult());
		
		}
}

