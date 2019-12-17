package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.bean.CartBean;
import com.capgemini.collection.bean.ProductBean;

public class CartDaoImpl implements CartDao {

	public static List<CartBean> cartList;
	public static List<ProductBean> productList;
	public static List<AdminBean> adminList;

	ProductBean productBean = null;
	CartBean cartBean = null;

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

	static {
		cartList = new ArrayList<CartBean>();
	}

	@Override
	public boolean addProductCart(int productId) {
		boolean isAdded = false;
		try {
			for (ProductBean productBean : productList) {
				if (productBean.getProductId() == productId) {
					int proId = productBean.getProductId();
					String proName = productBean.getProductName();
					int proPrice = productBean.getProductPrice();
					String proType = productBean.getProductTtpe();
					CartBean cartBean = new CartBean();
					cartBean.setProductId(proId);
					cartBean.setProductName(proName);
					cartBean.setProductPrice(proPrice);
					cartBean.setProductTtpe(proType);
					cartList.add(cartBean);
					isAdded = true;
				} // End of if
			} // End of for
		} catch (Exception e) {
			System.out.println("Something is wrong");
			isAdded = false;
		} // End of catch()
		return isAdded;
	}// End of addProductCart

	@Override
	public boolean viewAllProductCart() {
		boolean toDisplay = false;
		try {
			for (CartBean cartBean : cartList) {
				System.out.println("************************************");
				System.out.println("The ProductId: " + cartBean.getProductId());
				System.out.println("The ProductName: " + cartBean.getProductName());
				System.out.println("The ProductPrice: " + cartBean.getProductPrice());
				System.out.println("The ProductType: " + cartBean.getProductTtpe());
				System.out.println();
				toDisplay = true;
			} // End of for each
		} catch (Exception e) {
			System.out.println("Eighter database is Empty");
			toDisplay = false;
		} // End of catch()
		return toDisplay;
	}// End of viewAllProductCart()

	@Override
	public boolean totalBill() {
		boolean total = false;
		try {
			int totalBill = 0;
			for (CartBean cartBean : cartList) {
				int amount = cartBean.getProductPrice();
				totalBill = totalBill + amount;
			} // End of for
			if(totalBill>0) {
			System.out.println("Total Bill for the day " + totalBill);
			total = true;
			}else {
				total = false;	
			}//End of else
		} catch (Exception e) {
			System.out.println("Eighter Database is Empty.");
			System.out.println("Please Add product in Cart");
			total = false;
		} // End of catch()
		return total;
	}// End of totalBill

	@Override
	public boolean deleteItemCart(int productId) {
		boolean isDeleted = false;
		try {
			for (CartBean cartBean : cartList) {
				if (cartBean.getProductId() == productId) {
					cartList.remove(cartBean);
					isDeleted = true;
					return isDeleted;
				} else {// End of if
					isDeleted = false;
				} // End of for each
			} // End of for each

		} catch (Exception e) {
			System.out.println("Eighter there is no Item in Database");
			isDeleted = false;
		} // End of catch()
		return isDeleted;
	}// End of deleteItemCart()

	@Override
	public boolean deleteAllItem() {
		boolean isDeleted = false;
		try {
			for (CartBean cartBean : cartList) {
				cartList.removeAll(cartList);
				isDeleted = true;
			} // End of for each
			return isDeleted;
		} catch (Exception e) {
			isDeleted = false;
		} // End of catch()
		return isDeleted;
	}// End of deleteAllItem()

}// End of CartDaoImpl
