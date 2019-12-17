package com.capgemini.collection.dao;

public interface MessageDao {

	public boolean addMessage(int messageId, int userId, String message, String userType);

	public boolean viewAllMessage();
}// End of MessageDao
