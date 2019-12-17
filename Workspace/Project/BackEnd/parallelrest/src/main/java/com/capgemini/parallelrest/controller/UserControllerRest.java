package com.capgemini.parallelrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.parallelrest.beans.ResponseBean;
import com.capgemini.parallelrest.beans.UserBean;
import com.capgemini.parallelrest.service.UserBeanServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")//connection to angular
public class UserControllerRest {
	
	@Autowired
	private UserBeanServices userBeanServices;
	
	@GetMapping(path = "/userLogin")
	public ResponseBean userLogin(@RequestParam String email, @RequestParam String password) {
		UserBean user = userBeanServices.userLogin(email, password);
		ResponseBean responseBean = new ResponseBean();
		
		if(user!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Record Founded");
			responseBean.setUserBean(user);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Record Not Founed");
		}
		return responseBean;
	}//End of userLogin()
	
	@PutMapping(path = "/addRegister",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean addRegister(@RequestBody UserBean userBean) {
		UserBean bean = userBeanServices.addUser(userBean);
		ResponseBean responseBean = new ResponseBean();
		
		if(bean!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("User Registered successfully ");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("User failed to register");
		}//
		return responseBean;		
	}//End of addRegister()
	
	@GetMapping(path = "/showAllUser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showAllUser() {
		List<UserBean> data = userBeanServices.showAllUser();
		ResponseBean responseBean = new ResponseBean();
		
		if(data!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("List of All User");
			responseBean.setUserList(data);;
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("User failed to register");
		}
		return responseBean;
	}//End of showAllUser()
	
	@GetMapping(path = "/getUser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getUser(@RequestParam int userId) {
		UserBean isGetted = userBeanServices.getUser(userId);
		ResponseBean responseBean = new ResponseBean();
		
		if(isGetted!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Record Found");
			responseBean.setUserBean(isGetted);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Record Failed to Found");
		}
		return responseBean;
	}//End of getUser
	
	@DeleteMapping(path = "/removeUser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean removeUser(@RequestParam int userId) {
		boolean isDeleted = userBeanServices.removeUser(userId);
		ResponseBean responseBean = new ResponseBean();
		
		if(isDeleted) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Record Deleted");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Record Failed to Delete");
		}
		return responseBean;	
	}//End of removeUser
	
	@PostMapping(path = "/updateUser",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE } )
	public ResponseBean updateUser(@RequestBody UserBean userBean) {
		boolean isUpdate = userBeanServices.updateUser(userBean);
		ResponseBean responseBean = new ResponseBean();
		
		if(isUpdate) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Recorded Updated");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Record Failed to Updated");
		}
		return responseBean;
	}//End of updateUser

}//End of UserController
