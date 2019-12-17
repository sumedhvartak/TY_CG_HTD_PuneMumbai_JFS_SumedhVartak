package com.capgemini.parallel.dao;

import java.util.List;

import com.capgemini.parallel.beans.ProductBean;

public interface ProductDao {

	public List<ProductBean> viewAllProduct();
	public boolean addProduct(String productName, int productId, String productType, int productPrice);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(int productId, int productPrice);

}// End of ProductDao interface
