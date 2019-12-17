package com.capgemini.parallelhibernate.dao;


public interface CartDao {
	public boolean addProductCart(int productId,int productQuantity);
	public boolean deleteProductCart(int productId);
	public boolean updateProductCart(int productQuantity, int productId);
	public long addBill();
	public boolean AllProductCart();
	public boolean deleteAllCart();

}//End of CartDao
