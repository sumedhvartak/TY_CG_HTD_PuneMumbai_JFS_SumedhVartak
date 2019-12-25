package com.capgemini.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.BookingInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;
import com.capgemini.hotelmanagement.dao.EmployeeOperationDao;
import com.capgemini.hotelmanagement.validation.UserValidation;
import com.capgemini.hotelmanagement.validation.UserValidationImpl;

@Service
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

	@Autowired
	private EmployeeOperationDao employeeOperationDao;

	UserValidation userValidation = new UserValidationImpl();

	@Override
	public List<RoomInformationBean> getRoomList(String email) {
	List<RoomInformationBean> roomList = null;
		try {
			roomList = employeeOperationDao.getRoomList(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return roomList;
		
	}

	@Override
	public HotelInformationBean getHotelInformation(String email) {
		return employeeOperationDao.getHotelInformation(email);
	}

	@Override
	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean) {
		if (userValidation.nameValidation(bookingInformationBean.getName())
				&& userValidation.emailValidation(bookingInformationBean.getEmail())) {
			return employeeOperationDao.bookUser(bookingInformationBean);
		}
		return null;
	}
}// end of class
