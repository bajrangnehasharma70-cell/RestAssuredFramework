package models;

public class Booking_Data {
	
	private String firstName;
	private String lastName;
	private Integer totalprice;
	private Boolean depositpaid;
	private String additionalneeds;
	private Booking_Dates bookingdates;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public Boolean getDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(Boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	public Booking_Dates getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(Booking_Dates bookingdates) {
		this.bookingdates = bookingdates;
	}

}
