package com.capgemini.parallelrest.service;

import java.util.List;

import com.capgemini.parallelrest.beans.CartBean;

public interface CartService {
	
	public CartBean addCart(int productId);
	public List<CartBean> showCart();
	public boolean deleteCart(int cartId);
	public boolean deleteAllCart();
	public long totalBill();
}//End of CartService
