package com.capgemini.hotelmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagement.beans.EmployeeInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;
import com.capgemini.hotelmanagement.dao.AdminOperationsDaoImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminOperationsTest {
	
	@Autowired
	private AdminOperationsDaoImpl adminOperationsDaoImpl;
	
	//Hotel Test Cases
	
	//Passed
//	@Test
//	public void testAddHotel() {
//		HotelInformationBean hotelInformationBean = new HotelInformationBean();
//		hotelInformationBean.setAddress("Mumbai");
//		hotelInformationBean.setContactNumber("1234567890");
//		hotelInformationBean.setHotelName("Sanju Dhaba");
//		hotelInformationBean.setImgUrl("qwerty.image.url");
//		hotelInformationBean.setLicenseNumber("1234567");
//		
//		TestCase.assertNotNull(adminOperationsDaoImpl.addHotel(hotelInformationBean));
//		
//	}//End of testAddHotel()
	
	//Passed
//	@Test
//	public void testUpdateHotelRoom() {
//		HotelInformationBean hotelInformationBean = new HotelInformationBean();
//		hotelInformationBean.setHotelId(11);
//		hotelInformationBean.setAddress("Mumbai");
//		hotelInformationBean.setContactNumber("1234567890");
//		hotelInformationBean.setHotelName("Sau Dhaba");
//		hotelInformationBean.setImgUrl("qwy.image.url");
//		hotelInformationBean.setLicenseNumber("1234567");
//		
//		boolean actual = adminOperationsDaoImpl.updateHotelInformation(hotelInformationBean);
//		assertEquals(true, actual);
//		
//	}//End of testUpdateHotelRoom()
	
	//Passed
//	@Test
//	public void testDeleteHotelInformation() {
//		
//		boolean actual = adminOperationsDaoImpl.deleteHotelInformation(11);
//		assertEquals(true, actual);
//		
//	}//End of testDeleteHotelInformation()
	
	//Passed Just checking if particular License Number is present 

//	@Test
//	public void testLicenseNumberPresent() {
//		boolean actual = adminOperationsDaoImpl.licenseNumberPresent("H00000001");
//		assertEquals(true, actual);
//		
//	}//End of testLicenseNumberPresent()
	
	//Room Test Cases
	
	//Passed
//	@Test
//	public void testAddRoom() {
//		HotelInformationBean hotelInformationBean = new HotelInformationBean();
//		RoomInformationBean roomInformationBean = new RoomInformationBean();
//		roomInformationBean.setHotelLicense("H00000001");
//		roomInformationBean.setHotelName("Jamun");
//		roomInformationBean.setHotelId(2);
//		roomInformationBean.setRoomAmount(123);
//		roomInformationBean.setRoomCount(25);
//		roomInformationBean.setRoomImageUrl("asdf");
//		roomInformationBean.setRoomStatus("avaliable");
//		roomInformationBean.setRoomType("AC");
//		roomInformationBean.setRoomCapacity("singleBed");
//		
//		TestCase.assertNotNull(adminOperationsDaoImpl.addRoom(roomInformationBean));
//		
//		
//	}//End of testAddRoom()
	
	//Passed
//	@Test
//	public void testDeleteRoomInformation() {
//		
//		boolean actual = adminOperationsDaoImpl.deleteRoomInformation(2);
//		assertEquals(true, actual);
//		
//	}//End of testDeleteRoomInformation()
	
	//Passed
//	@Test
//	public void testUpdateRoomInformation() {
//		RoomInformationBean roomInformationBean = new RoomInformationBean();
//		roomInformationBean.setRoomId(4);
//		roomInformationBean.setHotelLicense("H01");
//		roomInformationBean.setHotelName("Jamun123");
//		roomInformationBean.setHotelId(22);
//		roomInformationBean.setRoomAmount(1233);
//		roomInformationBean.setRoomCount(225);
//		roomInformationBean.setRoomImageUrl("asdf");
//		roomInformationBean.setRoomStatus("avaliable");
//		roomInformationBean.setRoomType("nON -AC");
//		roomInformationBean.setRoomCapacity("singleBed");
//		
//		boolean actual = adminOperationsDaoImpl.updateRoomInformation(roomInformationBean);
//		assertEquals(true, actual);
//		
//	}//End of testUpdateRoomInformation()
	
	//Employee Crud Operation
	
	//Passed
//	@Test
//	public void testAddEmployee() {
//		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
//		employeeInformationBean.setAddress("Deli");
//		employeeInformationBean.setContactNumber("123678");
//		employeeInformationBean.setEmail("sm@gmail.com");
//		employeeInformationBean.setHotelId(1);
//		employeeInformationBean.setHotelLicense("H00000001");
//		employeeInformationBean.setHotelName("Cosms");
//		employeeInformationBean.setName("manju");
//		employeeInformationBean.setNationality("Inian");
//		employeeInformationBean.setPassword("manjuBaba");
//		
//		TestCase.assertNotNull(adminOperationsDaoImpl.addEmployee(employeeInformationBean));
//		
//	}//End of testAddEmployee()
	
	//Passed
//	@Test
//	public void testDeleteEmployee() {
//		boolean actual = adminOperationsDaoImpl.deleteEmployeeInformation(2);
//		assertEquals(true, actual);
//		
//	}//End of testDeleteEmployee()
	
	//Passed
//	@Test
//	public void testUpdateEmployeeInformation() {
//		
//	EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
//	employeeInformationBean.setEmployeeId(1);
//	employeeInformationBean.setAddress("Mumbai1");
//	employeeInformationBean.setContactNumber("123456789");
//	employeeInformationBean.setHotelId(2);
//	employeeInformationBean.setHotelLicense("123");
//	employeeInformationBean.setHotelName("Indus");
//	employeeInformationBean.setNationality("Indiam");
//	employeeInformationBean.setPassword("passwo3");
//	
//	boolean actual = adminOperationsDaoImpl.updateEmployeeInformation(employeeInformationBean);
//	assertEquals(true, actual);
//		
//	}//End of testUpdateEmployeeInformation()

}//End of AdminOperationsTest()
