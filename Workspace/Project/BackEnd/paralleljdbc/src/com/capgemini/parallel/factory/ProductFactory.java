package com.capgemini.parallel.factory;

import com.capgemini.parallel.dao.ProductDao;
import com.capgemini.parallel.dao.ProductDaoJdbcImpl;

public class ProductFactory {

	private ProductFactory() {

	}// End of Constructor

	public static ProductDao getInstance() {

		ProductDao dao = new ProductDaoJdbcImpl();
		return dao;
	}// End of getInstance()

}// End of ProductFactory
