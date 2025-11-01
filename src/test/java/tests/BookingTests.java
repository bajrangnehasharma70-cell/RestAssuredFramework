package tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import models.Booking_Data;
import models.Booking_Dates;
import restfulBooker.Bookings;

public class BookingTests {
	
	@Test
	public void createBookingWithDefaultPayload() {
		int bookingId = Bookings.createBooking();
		System.out.println(bookingId);
	}
	
	
	@Test
	public void createBookingWithPojo() {
		Booking_Dates bookingDate = new Booking_Dates();
		bookingDate.setCheckin("2025-01-02");
		bookingDate.setCheckout("2025-02-02");
		
		Booking_Data bookingData = new Booking_Data();
		bookingData.setFirstName("Jim");
		bookingData.setLastName("Brown");
		bookingData.setDepositpaid(true);
		bookingData.setTotalprice(123);
		bookingData.setAdditionalneeds("Lunch");
		
		bookingData.setBookingdates(bookingDate);
		
		int bookingId = Bookings.createBooking(bookingData);
		System.out.println(bookingId);
	}
	
	@Test
	public void createBookingWithMap() {
		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("firstname", "Jim");
		requestBody.put("lastname", "Brown");
		requestBody.put("totalprice", 123);
		requestBody.put("depositpaid", true);
		requestBody.put("additionalneeds", "Breakfast");
	
		HashMap<String, String> bookingDates = new HashMap<>();
		bookingDates.put("checkin", "2025-01-01");
		bookingDates.put("checkout", "2025-01-02");
	
	
	    requestBody.put("bookingdates", bookingDates);
	    int bookingId = Bookings.createBooking(requestBody);
		System.out.println(bookingId);
	}
	
	
	@Test
	public void createBookingWithFile() {
		
	}
	
	
	

}
