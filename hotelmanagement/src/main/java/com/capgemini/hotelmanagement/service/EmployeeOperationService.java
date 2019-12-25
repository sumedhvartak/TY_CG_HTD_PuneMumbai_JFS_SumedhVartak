package com.capgemini.hotelmanagement.service;

import java.util.List;

import com.capgemini.hotelmanagement.beans.BookingInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;

public interface EmployeeOperationService {

	public List<RoomInformationBean> getRoomList(String email);

	public HotelInformationBean getHotelInformation(String email);

	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean);
}// end of interface
