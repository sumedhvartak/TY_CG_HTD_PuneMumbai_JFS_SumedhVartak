package com.capgemini.parallelrest.dao;

import java.util.List;

import com.capgemini.parallelrest.beans.ProductBean;

public interface ProductDao {
	
	public boolean addProduct(ProductBean productBean);
	public List<ProductBean> showAllProduct();
	public boolean deleteProduct(int productId);
	public boolean updateProduct(int productId, int productPrice, int quantity);

}//End of Product
