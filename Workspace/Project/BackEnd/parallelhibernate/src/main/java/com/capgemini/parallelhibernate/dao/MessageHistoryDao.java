package com.capgemini.parallelhibernate.dao;


public interface MessageHistoryDao {
	
	public boolean insertCart(int userId, String userName);
	public boolean getCartInfo(int userId);
	public boolean getAllCartInfo();

}//End of MessageHistoryDao
