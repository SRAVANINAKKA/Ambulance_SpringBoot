package com.cg.Ambulance.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Ambulance Domain is used as data traveller object. 
 * All Project Validation will be performed here. * 
 * @author DELL
 *
 */
@Entity
public class Ambulance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Booking_id;
	@NotBlank(message = "Ambulance_Number is required")
	private String Ambulance_Number;
	@NotBlank(message = "DriverName is required")
	private String DriverName;
	@NotBlank(message = "UserName is required")
	private String UserName;
	@NotBlank(message = "UserAddress is required")
	private String UserAddress;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date DofBooking;
	

	public Ambulance() {
		super();
	}
	public Long getBooking_id() {
		return Booking_id;
	}
	public void setBooking_id(Long booking_id) {
		Booking_id = booking_id;
	}
	public String getAmbulance_Number() {
		return Ambulance_Number;
	}
	public void setAmbulance_Number(String ambulance_Number) {
		Ambulance_Number = ambulance_Number;
	}
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String Useraddress) {
		UserAddress = Useraddress;
	}
	public Date getDofBooking() {
		return DofBooking;
	}
	public void setDofBooking(Date DofBooking) {
		this.DofBooking = DofBooking;
	}
	
}
