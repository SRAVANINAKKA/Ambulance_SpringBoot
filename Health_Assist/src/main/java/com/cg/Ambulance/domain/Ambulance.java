package com.cg.Ambulance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Ambulance Domain is used as data traveller object. 
 * All Project Validation will be performed here. * 
 * @author DELL
 *
 */
@Entity
public class Ambulance {
	/**
	 * creating int instance variable Booking_id
	 */
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Booking_id;
	@NotBlank(message = "BookingIdentifier is required")
	@Size(min=4, max=5,message = "Size must be between 4 to 5 characters")
	@Column(unique = true,updatable = false)
	/**
	 * creating String instance variable bookingIdentifier
	 */
	private String bookingIdentifier;
	@NotBlank(message = "Ambulance_Number is required")
	/**
	 * creating String instance variable Ambulance_Number
	 */
	private String Ambulance_Number;
	/**
	 * creating String instance variable DriverName
	 */
	@NotBlank(message = "DriverName is required")
	private String DriverName;
	/**
	 * creating String instance variable UserName
	 */
	@NotBlank(message = "UserName is required")
	private String UserName;
	/**
	 * creating String instance variable UserAddress
	 */
	@NotBlank(message = "UserAddress is required")
	private String UserAddress;
	/**
	 * creating String instance variable bookingResult
	 */
	
	private String BookingResult;
	
	/**
	 * creating getter for Booking_id to get the details of Booking_id
	 * @return
	 */
	
	
	public int getBooking_id() {
		return Booking_id;
	}
	
	/**
	 * creating a setter for BookingId to the parameter value BookingId
	 * @param BookingId
	 */
	
	public void setBooking_id(int booking_id) {
		Booking_id = booking_id;
	}
	/**
	 * creating getter for BookingIdentifier to get the details of Bookingidentifier
	 * @return
	 */
	
	public String getBookingIdentifier() {
		return bookingIdentifier;
	}
	
	/**
	 * creating a setter for BookingIdentifier to the parameter value BookingIdentifier 
	 * @param BookingIdentifier
	 */
	
	public void setBookingIdentifier(String bookingIdentifier) {
		this.bookingIdentifier = bookingIdentifier;
	}
	
	/**
	 * creating getter for Ambulance_Number to get the details of Ambulance_Number
	 * @return
	 */
	public String getAmbulance_Number() {
		return Ambulance_Number;
	}
	
	/**
	 * creating a setter for Ambulance_Number to the parameter value Ambulance_Number 
	 * @param Ambulance_Number
	 */
	public void setAmbulance_Number(String ambulance_Number) {
		Ambulance_Number = ambulance_Number;
	}
	
	/**
	 * creating getter for DriverName  to get the details of DriverName
	 * @return
	 */
	
	public String getDriverName() {
		return DriverName;
	}
	
	/**
	 * creating a setter for driverName to the parameter value driverName 
	 * @param driverName
	 */
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	
	/**
	 * creating getter for UserName  to get the details of UserName
	 * @return
	 */
	
	public String getUserName() {
		return UserName;
	}
	
	/**
	 * creating a setter for userName to the parameter value userName 
	 * @param userName
	 */
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	/**
	 * creating getter for UserAddress  to get the details of UserAddress
	 * @return
	 */
	
	
	public String getUserAddress() {
		return UserAddress;
	}
	
	/**
	 * creating a setter for UserAddress to the parameter value for UserAddress
	 * @param Useraddress
	 */
	public void setUserAddress(String Useraddress) {
		UserAddress = Useraddress;
	}
	/**
	 * creating getter for BookingResult  to get the details of BookingResult
	 * @return
	 */

	public String getBookingResult() {
		return BookingResult;
	}
	
	/**
	 * creating a setter for bookingResult to the parameter value for bookingResult
	 * @param bookingResult
	 */
	public void setBookingResult(String bookingResult) {
		BookingResult = bookingResult;
	}
	
	/**
	 * creating a parameterized constructor to set the values passed as parameters to respective instance variables while creating constructor object 
	 * @param bookingId
	 * @param bookingIdentifier
	 * @param Ambulance_Number
	 * @param DriverName
	 * @param UserName
	 * @param UserAddress
	 *  @param  BookingResult
	 */
	
	public Ambulance(int Booking_id, String bookingIdentifier, String Ambulance_Number, String DriverName, String UserName, String UserAddress, String BookingResult) {
		super();
		this.Booking_id = Booking_id;
		this.bookingIdentifier = bookingIdentifier;
		this.Ambulance_Number=Ambulance_Number;
		this. DriverName=  DriverName;
		this.UserName=UserName;
		this.UserAddress=UserAddress;
		this. BookingResult= BookingResult;
	}
	
	/**
	 * creating a toString method to override the String statement of the object
	 */
	
	@Override
	public String toString() {
		return "Ambulance [Booking_id=" + Booking_id + ", bookingIdentifier=" + bookingIdentifier
				+ ", Ambulance_Number=" + Ambulance_Number + ", DriverName=" + DriverName + ", UserName=" + UserName
				+ ", UserAddress=" + UserAddress + ", BookingResult=" + BookingResult
				+ "]";
	}

	/**
	 * creating non-parameterized constructor 
	 */
	
	public Ambulance() {
		super();
	}
	
	}
	

