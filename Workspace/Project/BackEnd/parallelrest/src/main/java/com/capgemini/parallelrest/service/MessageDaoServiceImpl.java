package com.capgemini.parallelrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.parallelrest.beans.MessageBean;
import com.capgemini.parallelrest.dao.MessageDao;

@Service
public class MessageDaoServiceImpl implements MessageDaoService{
	
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public List<MessageBean> showAllMessage() {
		return messageDao.showAllMessage();
	}//End of showAllMessage()

	@Override
	public List<MessageBean> showAllMessage(int userId) {
		return messageDao.showAllMessage(userId);
	}//End of showAllMessage()

	

	@Override
	public boolean addMessageAdmin(int userId, String message, String type) {
		return messageDao.addMessageAdmin(userId, message, type);
	}//End of addMessageAdmin()

	@Override
	public boolean addMessage(int userId, String message, String type, String question) {
		return messageDao.addMessage(userId, message, type, question);
	}//End of addMessage()
	
	

}//End of MessageDaoServiceImpl
