package com.capgemini.parallel.dao;

import com.capgemini.parallel.beans.MessageBean;

public interface MessageDao {
	public MessageBean sendMessage(int messageId, int userId, String message, String type, String ask);
	public MessageBean getMessage();

}//End of MessageDao
