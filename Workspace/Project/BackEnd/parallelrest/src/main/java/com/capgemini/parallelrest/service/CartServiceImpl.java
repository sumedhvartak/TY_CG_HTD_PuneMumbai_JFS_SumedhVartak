package com.capgemini.parallelrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.parallelrest.beans.CartBean;
import com.capgemini.parallelrest.dao.CartDao;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;

	@Override
	public CartBean addCart(int productId) {
		return cartDao.addCart(productId);
	}//End of addCart

	@Override
	public List<CartBean> showCart() {
		return cartDao.showCart();
	}//End of showCart()

	@Override
	public boolean deleteCart(int cartId) {
		return cartDao.deleteCart(cartId);
	}//End of deleteCart

	@Override
	public boolean deleteAllCart() {
		return cartDao.deleteAllCart();
	}//End of deleteAllCart()

	@Override
	public long totalBill() {	
		return cartDao.totalBill();
	}//End of totalBill()

}//End of CartServiceImpl
