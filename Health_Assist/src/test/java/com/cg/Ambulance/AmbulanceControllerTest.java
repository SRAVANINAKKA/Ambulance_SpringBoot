package com.cg.Ambulance;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.Ambulance.domain.Ambulance;
import com.cg.Ambulance.service.AmbulanceService;
import com.cg.Ambulance.service.MapValidationErrorService;
import com.cg.Ambulance.web.AmbulanceController;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AmbulanceController.class)
public class AmbulanceControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AmbulanceService  ambulanceService;
	
	@MockBean
	MapValidationErrorService mapValidationErrorService;
private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	
	public void test_Save_GivenAmbulance() throws Exception{
		Ambulance newambulance = new Ambulance(1, "AE12", "12345","driver1", "user1", "Delhi", "Accepted");
		
		Mockito.when(ambulanceService.save(ArgumentMatchers.any())).thenReturn(newambulance);
		String json = mapper.writeValueAsString(newambulance);
		mockMvc.perform(post("/api/ambulances").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
		.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isMap()) 
		.andExpect(jsonPath("booking_id").value(1))
		.andExpect(jsonPath("bookingIdentifier").value("AE12"))
		.andExpect(jsonPath("ambulance_Number").value("12345"))
		.andExpect(jsonPath("driverName").value("driver1"))
		.andExpect(jsonPath("userName").value("user1"))
		.andExpect(jsonPath("userAddress").value("Delhi"))
		.andExpect(jsonPath("bookingResult").value("Accepted"));
		
	}
	
	@Test
	public void test_FindAll_ReturnListOfAllDoctors() throws Exception {
		List<Ambulance> list = new ArrayList<>();
		list.add(new Ambulance(1, "AE12", "12345","driver1", "user1", "Delhi", "Accepted"));
		list.add(new Ambulance(2, "AE13", "12345","driver2", "user2", "Mumbai", "Rejected"));
		list.add(new Ambulance(3, "AE14", "12345","driver3", "user3", "pune", "Accepted"));
		Mockito.when(ambulanceService.viewAllBookings()).thenReturn(list);
	    mockMvc.perform(get("/api/ambulances/all"))
	            .andExpect(status().isOk())
				.andExpect(jsonPath("$",Matchers.hasSize(3)))
				.andExpect(jsonPath("$[0].driverName",Matchers.equalTo("driver1")));
		
	}
	@Test
	public void test_getAmbulanceByBookingIdentifier() throws Exception {
		Ambulance ambulance = new Ambulance(1,"AE12","1234","driver1","user1","Delhi","Accepted");
		Mockito.when(ambulanceService.findAmbulanceByBookingIdentifier("AE12")).thenReturn(ambulance);
		mockMvc.perform(get("/api/ambulances/AE12"))
        .andExpect(status().isOk());
        
	}
	
	@Test
	public void test_UpdateBySpecialization_ReturnsUpdateDoctorDetails() throws Exception {
		Ambulance ambulance = new Ambulance(1,"AE12","1234","driver1","user1","Delhi","Accepted");
		Mockito.when(ambulanceService.updateByBookingResult("AE12", "Accepted")).thenReturn(ambulance);
		ambulance.setBookingResult("Accepted");
		String json = mapper.writeValueAsString(ambulance);
		mockMvc.perform(patch("/api/ambulances/result/AE12").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isCreated());
		       	
	}
	
	
}
