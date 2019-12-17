package com.capgemini.parallelrest.service;

import java.util.List;

import com.capgemini.parallelrest.beans.MessageBean;

public interface MessageDaoService {
	public List<MessageBean> showAllMessage();
	public List<MessageBean> showAllMessage(int userId);
	public boolean addMessage(int userId, String message, String type, String question);
	public boolean addMessageAdmin(int userId, String message, String type);
}//End of MessageDaoService
