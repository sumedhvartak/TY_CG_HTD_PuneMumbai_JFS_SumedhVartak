package com.capgemini.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.EmployeeInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;
import com.capgemini.hotelmanagement.dao.AdminOperationsDao;
import com.capgemini.hotelmanagement.validation.HotelValidationImpl;
import com.capgemini.hotelmanagement.validation.UserValidationImpl;

@Service
public class AdminOperationsServiceImpl implements AdminOperationsService {
	@Autowired
	private AdminOperationsDao adminOperationsDao;
	UserValidationImpl userValidation = new UserValidationImpl();
	HotelValidationImpl hotelValidation = new HotelValidationImpl();

	@Override
	public HotelInformationBean addHotel(HotelInformationBean hotelBean) {
		
		if (hotelValidation.licenseValidation(hotelBean.getLicenseNumber())) {
			return adminOperationsDao.addHotel(hotelBean);
		} else {
			return null;
		}
	}

	@Override
	public List<HotelInformationBean> getHotelList() {
		return adminOperationsDao.getHotelList();
	}

	@Override
	public boolean updateHotelInformation(HotelInformationBean hotelBean) {
		if (hotelValidation.licenseValidation(hotelBean.getLicenseNumber())
				&& hotelValidation.contactNumberValidation(hotelBean.getContactNumber())) {
			return adminOperationsDao.updateHotelInformation(hotelBean);
		}
		return false;
	}

	@Override
	public boolean deleteHotelInformation(int hotelId) {
		return adminOperationsDao.deleteHotelInformation(hotelId);
	}

	@Override
	public RoomInformationBean addRoom(RoomInformationBean roomBean) {
		return adminOperationsDao.addRoom(roomBean);
	}

	@Override
	public boolean deleteRoomInformation(int roomId) {
		return adminOperationsDao.deleteRoomInformation(roomId);
	}

	@Override
	public List<RoomInformationBean> getRoomList() {
		return adminOperationsDao.getRoomList();
	}

	@Override
	public boolean updateRoomInformation(RoomInformationBean roomBean) {
		if (hotelValidation.licenseValidation(roomBean.getHotelLicense())) {
			return adminOperationsDao.updateRoomInformation(roomBean);
		}
		return false;
	}

	@Override
	public EmployeeInformationBean addEmployee(EmployeeInformationBean employeeBean) {
		try {
			if (userValidation.nameValidation(employeeBean.getName())
					&& userValidation.emailValidation(employeeBean.getEmail())
					&& userValidation.passwordValidation(employeeBean.getPassword())
					&& hotelValidation.contactNumberValidation(employeeBean.getContactNumber())) {
				return adminOperationsDao.addEmployee(employeeBean);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return null;
	
	}

	@Override
	public List<EmployeeInformationBean> getEmployeeList() {
		return adminOperationsDao.getEmployeeList();
	}

	@Override
	public boolean deleteEmployeeInformation(int employeeId) {
		return adminOperationsDao.deleteEmployeeInformation(employeeId);
	}

	@Override
	public boolean updateEmployeeInformation(EmployeeInformationBean employeeBean) {
		if (userValidation.nameValidation(employeeBean.getName())
				&& userValidation.emailValidation(employeeBean.getEmail())
				&& userValidation.passwordValidation(employeeBean.getPassword())) {
			return adminOperationsDao.updateEmployeeInformation(employeeBean);
		}
		return false;
	}

	@Override
	public boolean licenseNumberPresent(String licenseNumber) {
		return adminOperationsDao.licenseNumberPresent(licenseNumber);
	}
}
