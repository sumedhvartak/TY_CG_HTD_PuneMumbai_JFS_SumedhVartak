package com.capgemini.parallelhibernate.dao;


public interface MessageDao {
	
	public boolean addMessage(int userId, String message, String type, String ask);
	public boolean getMessage(int userId);
	public boolean getAllMessage();
}//End of MessageDao
