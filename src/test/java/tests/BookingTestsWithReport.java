package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import models.Booking_Data;
import models.Booking_Dates;
import restfulBooker.Bookings;


@Epic("Restful Booker Booking")
@Feature("Booking Management")
public class BookingTestsWithReport {

	
	@Test(description = "Create booking with default payload")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Bajrang")
	@Story("Create Booking")
	public void createBookingWithDefaultPayload() {
		int bookingId = Bookings.createBooking();
		System.out.println(bookingId);
	}

	@Test(description = "Create booking with pojo payload")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Bajrang")
	@Story("Create Booking with Pojo")
	public void createBookingWithPojo() {
		Booking_Dates bookingDate = new Booking_Dates();
		bookingDate.setCheckin("2025-01-02");
		bookingDate.setCheckout("2025-02-02");

		Booking_Data bookingData = new Booking_Data();
		bookingData.setFirstname("Jim");
		bookingData.setLastname("Brown");
		bookingData.setDepositpaid(true);
		bookingData.setTotalprice(123);

		bookingData.setBookingdates(bookingDate);
		bookingData.setAdditionalneeds("Lunch");

		int bookingId = Bookings.createBooking(bookingData);
		System.out.println(bookingId);
	}

}
