package restfulBooker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import models.Booking_Data;
import utils.PropertiesFileUtils;
import utils.RestCallUtils;

public class Bookings {

	static Properties baseUrls;
	static Properties basePaths;

	static {
		try {
			baseUrls = PropertiesFileUtils.loadProprtyFile("dev_baseUrls");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			basePaths = PropertiesFileUtils.loadProprtyFile("basePaths");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int createBooking() {
		String requestPayload = "{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";

		Response createBookingResponse = RestCallUtils
				.perfromPOSTCall(baseUrls.getProperty("restFullBooker"), basePaths.getProperty("createBooking"), requestPayload);
		return createBookingResponse.jsonPath().getInt("bookingid");
	}
		
	public static int createBooking(Booking_Data bookingRequestPayload) {	
		Response createBookingResponse = RestCallUtils
				.perfromPOSTCall(baseUrls.getProperty("restFullBooker"), basePaths.getProperty("createBooking"), bookingRequestPayload);
		return createBookingResponse.jsonPath().getInt("bookingid");		
	}
	
	public static int createBooking(Map<String, Object> createBookingRequest) { 
		Response createBookingResponse = RestCallUtils
				.perfromPOSTCall(baseUrls.getProperty("restFullBooker"), basePaths.getProperty("createBooking"), createBookingRequest);
		return createBookingResponse.jsonPath().getInt("bookingid");

	}
	
	public static int createBooking(File createbookingPayload ) {
		Response createBookingResponse = RestCallUtils
				.perfromPOSTCall(baseUrls.getProperty("restFullBooker"), basePaths.getProperty("createBooking"), createbookingPayload);
		return createBookingResponse.jsonPath().getInt("bookingid");	
	}
}

 