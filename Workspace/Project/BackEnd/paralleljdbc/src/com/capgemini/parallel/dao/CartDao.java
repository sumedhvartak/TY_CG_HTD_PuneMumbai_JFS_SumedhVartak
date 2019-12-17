package com.capgemini.parallel.dao;

import java.util.List;

import com.capgemini.parallel.beans.ProductBean;

public interface CartDao {
	
	public boolean addProductCart(ProductBean productBean);
	public boolean deleteProductCart(int productId);
	public List<ProductBean> viewAllCart();
	public boolean deleteAllCart();
	public boolean sum();
}//End of Cart
