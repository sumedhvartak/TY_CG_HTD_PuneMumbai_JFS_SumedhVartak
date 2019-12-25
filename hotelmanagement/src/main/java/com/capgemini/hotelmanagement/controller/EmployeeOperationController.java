package com.capgemini.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagement.beans.BookingInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.HotelManagementResponse;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;
import com.capgemini.hotelmanagement.service.EmployeeOperationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class EmployeeOperationController {

	@Autowired
	private EmployeeOperationService employeeOperationService;

	@GetMapping(path = "/getRoomListForEmployee")
	public HotelManagementResponse getRoomListForEmployee(@RequestParam String email) {
		// String licenceNumber = roomInformationBean.getHotelLicense();
		HotelManagementResponse response = new HotelManagementResponse();
		try {
			List<RoomInformationBean> roomList = employeeOperationService.getRoomList(email);
			if (roomList != null && !roomList.isEmpty()) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("room list displayed");
				response.setRoomList(roomList);
				;
			} else {
				response.setStatusCode(400);
				response.setMessage("Failed");
				response.setDescription("room list can't be fetched");
			}
		} catch (Exception e) {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription(e.getMessage());
			System.out.println(e.getMessage());
		}
		return response;
	}// end of getRoomListForEmployee

	@GetMapping(path = "/getHotelInfoForEmployee")
	public HotelManagementResponse getHotelInfoForEmployee(@RequestParam String email) {
		//String licenceNumber = hotelInformationBean.getLicenseNumber();
		HotelManagementResponse response = new HotelManagementResponse();
		try {
			HotelInformationBean hotelInfo = employeeOperationService.getHotelInformation(email);
			if (hotelInfo != null) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("hotel Info displayed");
				response.setHotelInformationBean(hotelInfo);
				;
			} else {
				response.setStatusCode(400);
				response.setMessage("Failed");
				response.setDescription("hotel Info can't be fetched");
			}
		} catch (Exception e) {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription(e.getMessage());
			System.out.println(e.getMessage());
		}
		return response;
	}// end of getHotelInfoForEmployee

	@PutMapping(path = "/hotelBookingFromEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse hotelBookingFromEmployee(
			@RequestBody BookingInformationBean bookingInformationBean) {
		HotelManagementResponse response = new HotelManagementResponse();
		BookingInformationBean bookingInformationBean1 = null;
		try {
			bookingInformationBean1 = employeeOperationService.bookUser(bookingInformationBean);
			if (bookingInformationBean1 != null) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("room booked successfully");

			} else {
				response.setStatusCode(400);
				response.setMessage("Failed");
				response.setDescription("Unable to book room");
			}
		} catch (Exception e) {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription(e.getMessage());
			System.out.println(e.getMessage());
		}
		return response;
	}// end of hotelBookingFromEmployee

}// end of class
