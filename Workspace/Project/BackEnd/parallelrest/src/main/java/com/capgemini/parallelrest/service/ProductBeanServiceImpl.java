package com.capgemini.parallelrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.parallelrest.beans.ProductBean;
import com.capgemini.parallelrest.dao.ProductDao;

@Service
public class ProductBeanServiceImpl implements ProductBeanService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public boolean addProduct(ProductBean productBean) {
		return productDao.addProduct(productBean);
	}//End of addProduct()

	@Override
	public List<ProductBean> showAllProduct() {
		return productDao.showAllProduct();
	}//End of showAllProduct

	@Override
	public boolean deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}//End of deleteProduct()

	@Override
	public boolean updateProduct(int productId, int productPrice, int quantity) {
		return productDao.updateProduct(productId, productPrice,quantity);
	}//End of updateProduct()

}//End of addProduct()
