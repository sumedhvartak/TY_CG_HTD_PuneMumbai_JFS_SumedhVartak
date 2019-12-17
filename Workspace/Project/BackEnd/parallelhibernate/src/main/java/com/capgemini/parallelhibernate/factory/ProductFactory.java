package com.capgemini.parallelhibernate.factory;

import com.capgemini.parallelhibernate.dao.ProductDao;
import com.capgemini.parallelhibernate.dao.ProductDaoImpl;

public class ProductFactory {
	
	private ProductFactory() {
		
	}//End of ProductFactory()
	
	public static ProductDao getInstance() {
		
		ProductDao dao = new ProductDaoImpl();
		return dao;
		
	}//End of getInstance()

}//End of pr
