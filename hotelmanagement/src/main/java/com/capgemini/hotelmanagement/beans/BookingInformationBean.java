package com.capgemini.hotelmanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_information")
public class BookingInformationBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@Column
	private double bookingAmount;
	@Column
	private String roomType;
	@Column
	private String roomCapacity;
	@Column
	private String email;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String contactNumber;
	@Column
	private String nationality;
	@Column
	private String licenceNumber;
	@Column
	private String hotelName;

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(String roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}// end of class
