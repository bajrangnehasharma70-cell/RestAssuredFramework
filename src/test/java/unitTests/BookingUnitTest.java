//package unitTests;
//
//
//import java.util.HashMap;
//
//import io.restassured.response.Response;
//import models.Booking_Data;
//import models.Booking_Dates;
//import restfulBooker.Bookings;
//import utils.Book_Data;
//import utils.Book_Date;
//import utils.ResponseValidationUtils;
//
//public class BookingUnitTest {
//	
//	public static void main(String[] args) {
//		
//		// just create booking with any random data
//		int bookingId = Bookings.createBooking();
//		System.out.println(bookingId);
//		
//		// create booking with a POJO data
//		Booking_Dates bookingDate = new Booking_Dates();
//		bookingDate.setCheckin("2025-01-02");
//		bookingDate.setCheckout("2025-02-02");
//		
//		Booking_Data bookingData = new Booking_Data();
//		bookingData.setFirstname("Jim");
//		bookingData.setLastname("Brown");
//		bookingData.setDepositpaid(true);
//		bookingData.setTotalprice(123);
//		bookingData.setAdditionalneeds("Lunch");
//		
//		bookingData.setBookingdates(bookingDate);
//		
//		
//		
//		bookingId = Bookings.createBooking(bookingData);
//		System.out.println(bookingId);
//				
//		
//		// create booking with a Map request payload
//		HashMap<String, Object> requestBody = new HashMap<>();
//		requestBody.put("firstname", "Jim");
//		requestBody.put("lastname", "Brown");
//		requestBody.put("totalprice", 123);
//		requestBody.put("depositpaid", true);
//		requestBody.put("additionalneeds", "Breakfast");
//	
//		HashMap<String, String> bookingDates = new HashMap<>();
//		bookingDates.put("checkin", "2025-01-01");
//		bookingDates.put("checkout", "2025-01-02");
//	
//	
//	    requestBody.put("bookingdates", bookingDates);
//	    bookingId = Bookings.createBooking(requestBody);
//		System.out.println(bookingId);
//		
//		// create booking with file
//		
//			
//	    
//	}
//	
//		
//
//}
//
//
