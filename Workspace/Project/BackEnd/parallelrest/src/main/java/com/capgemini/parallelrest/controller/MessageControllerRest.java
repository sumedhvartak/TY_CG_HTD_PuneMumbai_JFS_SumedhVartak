package com.capgemini.parallelrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.parallelrest.beans.MessageBean;
import com.capgemini.parallelrest.beans.ResponseBean;
import com.capgemini.parallelrest.service.MessageDaoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageControllerRest {
	
	@Autowired
	private MessageDaoService messageDaoService;
	
	@GetMapping(path ="/showAllMessage",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showAllMessage() {
		List<MessageBean> list = messageDaoService.showAllMessage();
		ResponseBean responseBean = new ResponseBean();		
		if(list!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("The List of All Message");
			responseBean.setMessageList(list);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Failed to load List");
		}//End of else
		return responseBean;	
	}//End of showAllUser()
	
	@GetMapping(path = "/showAllMessageUser",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showAllMessage(@RequestParam int userId) {
		List<MessageBean> list = messageDaoService.showAllMessage(userId);
		ResponseBean responseBean = new ResponseBean();		
		if(list!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("The List of All Message");
			responseBean.setMessageList(list);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Failed to load List");
		}//End of else
		return responseBean;
	}
	
	@PutMapping(path = "/addMessage",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean addMessage(@RequestParam int userId,@RequestParam String message,@RequestParam String type,@RequestParam String question) {
		boolean insert = messageDaoService.addMessage(userId, message, type, question);
		ResponseBean responseBean = new ResponseBean();
		
		if(insert) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("Message Added ");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Message Failed to Add");
		}//End of else
		return responseBean;
		
	}//End of addMessage()
	
	@PutMapping(path = "/addMessageAdmin",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean addMessageAdmin(@RequestParam int userId,@RequestParam String message,@RequestParam String type) {
		boolean insert = messageDaoService.addMessageAdmin(userId, message, type);
		ResponseBean responseBean = new ResponseBean();
		
		if(insert) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("Message Added ");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Message Failed to Add");
		}//End of else
		return responseBean;
		
	}//End of addMessageAdmin()
	
}//End of MessageControllerRest()
