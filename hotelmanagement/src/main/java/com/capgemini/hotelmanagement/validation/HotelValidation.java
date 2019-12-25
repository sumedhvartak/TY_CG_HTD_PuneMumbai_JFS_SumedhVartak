package com.capgemini.hotelmanagement.validation;

public interface HotelValidation {
	public boolean nameValidation(String name);
	public boolean licenseValidation (String licenseNumber);
	public boolean contactNumberValidation (String contactNumber);
//	public boolean roomCapacityValidation(String capacity);
}
