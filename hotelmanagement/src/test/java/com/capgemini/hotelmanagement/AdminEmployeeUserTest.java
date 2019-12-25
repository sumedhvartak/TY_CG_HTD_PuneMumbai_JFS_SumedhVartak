package com.capgemini.hotelmanagement;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagement.beans.AdminEmployeeUserBean;
import com.capgemini.hotelmanagement.dao.AdminEmployeeUserDaoImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminEmployeeUserTest {
	
	@Autowired
	private AdminEmployeeUserDaoImpl adminEmployeeUserDaoImpl; //autowired
	//Passed
//	@Test
//	public void testGetLogin() {
//		TestCase.assertNotNull(adminEmployeeUserDaoImpl.getLogin("user@gmail.com", "User123"));
//		
//	}//End of testGetLogin()
//	
	
	//Passed
//	@Test
//	public void testUserRegister() {
//		AdminEmployeeUserBean adminEmployeeUserBean = new AdminEmployeeUserBean();
//		adminEmployeeUserBean.setAddress("Mumbai");
//		adminEmployeeUserBean.setContactNumber("12345678");
//		adminEmployeeUserBean.setEmail("sanju@gmail.com");
//		adminEmployeeUserBean.setName("Sanju");
//		adminEmployeeUserBean.setNationality("Indian");
//		adminEmployeeUserBean.setPassword("sanjubaba");
//		adminEmployeeUserBean.setType("user");
//		
//		TestCase.assertNotNull(adminEmployeeUserDaoImpl.userRegister(adminEmployeeUserBean));
//		
//	}//End of testUserRegister()

}//End of AdminEmployeeUserTest()
