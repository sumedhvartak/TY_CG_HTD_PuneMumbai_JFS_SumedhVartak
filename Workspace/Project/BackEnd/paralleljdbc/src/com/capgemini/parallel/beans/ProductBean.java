package com.capgemini.parallel.beans;

public class ProductBean {

	private int productId;
	private String productName;
	private String productType;
	private int productPrice;

	// Getter and Setter

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

//	@Override
//	public String toString() {
//		return "ProductBean [productId=" + productId + ", productName=" + productName + ", productType=" + productType
//				+ ", productPrice=" + productPrice + "]";
//	}

}// End of Product Bean
