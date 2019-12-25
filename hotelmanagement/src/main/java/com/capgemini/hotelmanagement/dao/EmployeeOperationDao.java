package com.capgemini.hotelmanagement.dao;

import java.util.List;

import com.capgemini.hotelmanagement.beans.BookingInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;

public interface EmployeeOperationDao {

	public HotelInformationBean getHotelInformation(String email);

	public List<RoomInformationBean> getRoomList(String email);

	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean);

}// end of interface
