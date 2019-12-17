package com.capgemini.parallelrest.service;

import java.util.List;

import com.capgemini.parallelrest.beans.ProductBean;

public interface ProductBeanService {
	
	public boolean addProduct(ProductBean productBean);
	public List<ProductBean> showAllProduct();
	public boolean deleteProduct(int productId);
	public boolean updateProduct(int productId, int productPrice, int quantity);

}//End of ProductBeanService
