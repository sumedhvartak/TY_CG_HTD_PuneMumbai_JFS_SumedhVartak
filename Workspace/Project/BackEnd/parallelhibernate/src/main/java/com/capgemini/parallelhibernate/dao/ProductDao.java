package com.capgemini.parallelhibernate.dao;

import com.capgemini.parallelhibernate.beans.ProductBean;

public interface ProductDao {
	
	public boolean addProduct(ProductBean productBean);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(int productId, int price, int productQuantity, String productStatus);
	public void AllProduct();

}//End of ProductDao
