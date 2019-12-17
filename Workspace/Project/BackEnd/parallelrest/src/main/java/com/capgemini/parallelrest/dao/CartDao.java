package com.capgemini.parallelrest.dao;

import java.util.List;

import com.capgemini.parallelrest.beans.CartBean;

public interface CartDao {
	
	public CartBean addCart(int productId);
	public List<CartBean> showCart();
	public boolean deleteCart(int cartId);
	public boolean deleteAllCart();
	public long totalBill();

}//End of Cart()
