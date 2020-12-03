package com.cg.Ambulance.exception;

public class BookingIdExceptionResponse {
	private String bookingIdentifier;
	public BookingIdExceptionResponse(String bookingIdentifier) {
		super();
		this.bookingIdentifier = bookingIdentifier;
	}
	public String getBookingIdentifier() {
		return bookingIdentifier;
	}
	public void setBookingIdentifier(String bookingIdentifier) {
		this.bookingIdentifier = bookingIdentifier;
	}
	
	

}
