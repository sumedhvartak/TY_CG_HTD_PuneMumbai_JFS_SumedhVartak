package com.capgemini.collection.dao;

public interface CartDao {

	public boolean addProductCart(int productId);

	public boolean viewAllProductCart();

	public boolean totalBill();

	public boolean deleteItemCart(int productId);

	public boolean deleteAllItem();

}// End of CartDao
