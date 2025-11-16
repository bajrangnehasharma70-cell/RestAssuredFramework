package models.response;

import models.Booking_Data;

public class CreateBookingResponse {
	
	private int bookingid;
	private Booking_Data booking;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public Booking_Data getBooking() {
		return booking;
	}
	public void setBooking(Booking_Data booking) {
		this.booking = booking;
	}
	
	
}
