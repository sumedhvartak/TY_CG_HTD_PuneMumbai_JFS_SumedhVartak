package com.capgemini.hotelmanagement;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagement.dao.EmployeeOperationDaoImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeOperationTest {
	
	@Autowired
	private EmployeeOperationDaoImpl employeeOperationDaoImpl;
	
	//Passed Case with valid Information
//	@Test
//	public void testGetHotelInformation() {
//		
//		TestCase.assertNotNull(employeeOperationDaoImpl.getHotelInformation("sam@gmail.com"));
//		
//	}//End of testGetHotelInformation()
	
	//Failed Test Case with invalid Information
//	@Test
//	public void testGetHotelInformation() {
//		
//		TestCase.assertNotNull(employeeOperationDaoImpl.getHotelInformation("employee123@qwerty.com"));
//		
//	}//End of testGetHotelInformation()
	
	


}//End of EmployeeOperationTest()
