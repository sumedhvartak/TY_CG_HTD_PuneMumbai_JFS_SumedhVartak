package com.capgemini.parallelrest.dao;

import java.util.List;

import com.capgemini.parallelrest.beans.MessageBean;

public interface MessageDao {
	
	public boolean addMessage(int userId, String message, String type, String question);//user
	public List<MessageBean> showAllMessage(int userId);//user
	public List<MessageBean> showAllMessage();//Admin
	public boolean addMessageAdmin(int userId, String message, String type);

}//End of MessageDao
