package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.Booking_Data;
import models.Booking_Dates;
import restfulBooker.Bookings;
import utils.ResponseValidationUtils;

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
		
		
		bookingData.setBookingdates(bookingDate);
		bookingData.setAdditionalneeds("Lunch");
		
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
	    Response createBooking = Bookings.createBooking(requestBody);
		int actualStatusCode = ResponseValidationUtils.getStatusCode(createBooking);
		Assert.assertEquals(actualStatusCode, 200, "Status code is not matched.");
		
		long actualResponseTime = ResponseValidationUtils.getResponseTime(createBooking);
		System.out.println("Actual response time " + actualResponseTime);
		Assert.assertTrue(actualResponseTime < 1000, "Response time is greater than 1000 ms");
		
		ResponseValidationUtils.isResponseTimeLessThan(createBooking, 1000);
		
		String bookingId = String.valueOf(ResponseValidationUtils.getValueFromResponseUsingJsonPath(createBooking, "bookingid"));
		System.out.println(bookingId);
		Assert.assertTrue(bookingId != null, "Booking id is null");
		
		List<String> jsonPaths = new ArrayList();
		jsonPaths.add("bookingid");
		jsonPaths.add("booking.firstname");
		
		Map<String, Object> valuesFromResponse = 
				ResponseValidationUtils.getValueFromResponseUsingJsonPath(createBooking, jsonPaths);
		
		System.out.println(valuesFromResponse);
	}
	
	
	@Test
	public void createBookingWithFile() {
		
	}
	
	
	

}
