package com.capgemini.collection.dao;

import com.capgemini.collection.bean.ProductBean;

public interface ProductDao {

	public ProductBean allProduct();

	public ProductBean addProduct(int productId, String productName, String productType, int productPrice);

	public boolean deleteProduct(int productId);

	public ProductBean updateProduct(int productId, int productPrice);

}// End of ProductDao
