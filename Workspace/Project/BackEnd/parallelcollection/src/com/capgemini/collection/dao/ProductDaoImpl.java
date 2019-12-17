package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.collection.bean.ProductBean;

public class ProductDaoImpl implements ProductDao {

	public static List<ProductBean> productList;
	ProductBean productBean = null;

	static {
		productList = new ArrayList<ProductBean>();

		ProductBean productBean = new ProductBean();
		ProductBean productBean1 = new ProductBean();

		productBean.setProductId(101);
		productBean.setProductName("Nivea");
		productBean.setProductPrice(112);
		productBean.setProductTtpe("FaceCare");

		productBean1.setProductId(102);
		productBean1.setProductName("Nivea Lotion");
		productBean1.setProductPrice(145);
		productBean1.setProductTtpe("BodyCare");

		productList.add(productBean);
		productList.add(productBean1);
	}// End of static

	@Override
	public ProductBean allProduct() {
		try {
			for (ProductBean product : productList) {
				System.out.println();
				System.out.println("***********************************");
				System.out.println("The Product Id :" + product.getProductId());
				System.out.println("The Product Name: " + product.getProductName());
				System.out.println("The Product Price: " + product.getProductPrice());
				System.out.println("The Product Type: " + product.getProductTtpe());
				System.out.println("***********************************");
				System.out.println();
				this.productBean = product;
			} // End of for each
			return productBean;
		} catch (Exception e) {
			return productBean;
		} // End of catch()
	}// End of allProduct()

	@Override
	public ProductBean addProduct(int productId, String productName, String productType, int productPrice) {
		boolean added = false;
		ProductBean product = new ProductBean();
		try {
			for (ProductBean broduct : productList) {
				if (broduct.getProductId() == productId) {
					added = true;
					this.productBean = null;
					return productBean;
				} // End of if block
			} // End of for loop
			if (!added) {
				product.setProductId(productId);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setProductTtpe(productType);
				productList.add(product);
				System.out.println("");
				System.out.println("***********************************");
				System.out.println("The Product Id :" + product.getProductId());
				System.out.println("The Product Name: " + product.getProductName());
				System.out.println("The Product Price: " + product.getProductPrice());
				System.out.println("The Product Type: " + product.getProductTtpe());
				System.out.println("***********************************");
				System.out.println();
				this.productBean = product;
				return productBean;
			} // End of if and also if above data is stored in above for each loop then data
				// is overridden and data is repeated
				// for ex.if u have hard coded then it will replace by coded data
		} catch (Exception e) {
			return productBean;
		} // End of catch()
		return productBean;
	}// End of addProduct()

	@Override
	public ProductBean updateProduct(int productId, int productPrice) {
		try {
			for (ProductBean product : productList) {
				if (productId == product.getProductId()) {
					product.setProductPrice(productPrice);
					// productList.add(product);
					System.out.println("The Product Id: " + product.getProductId());
					System.out.println("The Product Name: " + product.getProductName());
					System.out.println("The Product Price:" + product.getProductPrice());
					System.out.println("The Product type: " + product.getProductTtpe());
					this.productBean = product;
					return productBean;
				} // End of if
			} // End of for each
		} catch (Exception e) {
			return productBean;
		} // End of catch()
		return productBean;
	}// End of update Price

	@Override
	public boolean deleteProduct(int productId) {
		boolean deleted = false;
		try {
			for (ProductBean product : productList) {
				if (productId == product.getProductId()) {
					productList.remove(product);
					deleted = true;
					break;
				} else {
					deleted = false;
				} // End of else
			} // End of for each
		} catch (Exception e) {
			deleted = false;
		} // End of catch()
		return deleted;
	}// End of deleteProduct()

}// End of ProductDaoImpl
