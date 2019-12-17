package com.capgemini.collection.factory;

import com.capgemini.collection.dao.ProductDao;
import com.capgemini.collection.dao.ProductDaoImpl;

public class ProductFactory {

	private ProductFactory() {

	}// End of ProductFactory()

	public static ProductDao getInstance() {
		ProductDao dao = new ProductDaoImpl();
		return dao;

	}// End of ProductDao
}// End of productFactory
