package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.ProductBean;
import com.capgemini.parallelhibernate.dao.ProductDao;
import com.capgemini.parallelhibernate.dao.UserDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.ProductFactory;
import com.capgemini.parallelhibernate.factory.UserFactory;

public class Admin {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	// Product
	static Integer productId;
	static Integer productPrice;
	static String productName;
	static String productType;
	static String productStatus;
	static Integer productQuantity;

	// User
	static Integer userId;
	static String userName;
	static String email;
	static String password;
	static Integer mobile;


	public void addProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			Scanner sc = new Scanner(System.in);
			ProductBean productBean = new ProductBean();

//			System.out.println("Entered ProductId");
//			productBean.setProductId(Integer.parseInt(sc.nextLine()));
			valid = true;
			while (valid) {
				System.out.println("Enter ProductId");
				String productIdR = sc.nextLine();
				try {
					productId = ExceptionHandling.numValidation(productIdR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			productBean.setProductId(productId);
			
//			System.out.println("Entered ProductName");
//			productBean.setProductName(sc.nextLine());
			valid = true;
			while (valid) {
				System.out.println("Enter ProductName");
				String productNameR = sc.nextLine();
				try {
					productName = ExceptionHandling.productNameTypeVal(productNameR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			productBean.setProductName(productName);
			
//			System.out.println("Entere ProductPrice");
//			productBean.setProductPrice(Integer.parseInt(sc.nextLine()));
			valid = true;
			while (valid) {
				System.out.println("Enter ProductPrice");
				String productPriceR = sc.nextLine();
				try {
					productPrice = ExceptionHandling.numValidation(productPriceR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			productBean.setProductPrice(productPrice);
			
//			System.out.println("Entered Product Type");
//			productBean.setProductType(sc.nextLine());
			valid = true;
			while (valid) {
				System.out.println("Enter ProductType");
				String productTypeR = sc.nextLine();
				try {
					productType = ExceptionHandling.productNameTypeVal(productTypeR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			productBean.setProductType(productType);
			
			
//			System.out.println("Entered Product Status");
			valid = true;
			while (valid) {
				System.out.println("Enter ProductStatus");
				String productStatusR = sc.nextLine();
				try {
					productStatus = ExceptionHandling.productNameTypeVal(productStatusR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			productBean.setStatus(productStatus);
			
//			System.out.println("Enter Product Quantity");
			valid = true;
			while (valid) {
				System.out.println("Enter ProductQuantity");
				String productQuantityR = sc.nextLine();
				try {
					productQuantity = ExceptionHandling.numValidation(productQuantityR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			productBean.setQuantity(productQuantity);
			boolean addProduct = dao.addProduct(productBean);
			if (addProduct) {
				System.out.println("Product Added Successfully");
			} else {
				System.out.println("Something went wrong");
			} // End of else
		} catch (Exception e) {
			System.out.println("Invalid Credntials");
			addProduct();
		} // End of catch()

	}// End of addProduct()

	public void deleteProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			// ProductBean productBean = new ProductBean();
			//Scanner sc = new Scanner(System.in);
//			System.out.println("Enter ProductId");
//			int productId = Integer.parseInt(sc.nextLine());
			valid = true;
			while (valid) {
				System.out.println("Enter ProductId");
				String productIdR = sc.nextLine();
				try {
					productId = ExceptionHandling.numValidation(productIdR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			
			boolean deleteProduct = dao.deleteProduct(productId);
			if (deleteProduct) {
				System.out.println("Product deleted successfully");
			} else {
				System.out.println("Failed to delete product");
			} // End of else
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			deleteProduct();
		} // End of catch()
	}// End of deleteProduct()

	public void updateProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			//Scanner sc = new Scanner(System.in);
//			System.out.println("Enter ProductId");
//			int productId = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter productPrice");
//			int productPrice = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter productQuantity");
//			int productQuantity = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter ProductStatus");
//			String productStatus = sc.nextLine();
			valid = true;
			while (valid) {
				System.out.println("Enter ProductId");
				String productIdR = sc.nextLine();
				try {
					productId = ExceptionHandling.numValidation(productIdR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			
			valid = true;
			while (valid) {
				System.out.println("Enter ProductPrice");
				String productPriceR = sc.nextLine();
				try {
					productPrice = ExceptionHandling.numValidation(productPriceR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			
			valid = true;
			while (valid) {
				System.out.println("Enter ProductStatus");
				String productStatusR = sc.nextLine();
				try {
					productStatus = ExceptionHandling.productNameTypeVal(productStatusR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			
//			System.out.println("Enter Product Quantity");
			valid = true;
			while (valid) {
				System.out.println("Enter ProductQuantity");
				String productQuantityR = sc.nextLine();
				try {
					productQuantity = ExceptionHandling.numValidation(productQuantityR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			boolean updateProduct = dao.updateProduct(productId, productPrice, productQuantity, productStatus);
			if (updateProduct) {
				System.out.println("Product Updated successfully");
			} else {
				System.out.println("Failed to update the product");
			} // End of else
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			updateProduct();
		} // End of catch()
	}// End of updateProduct()

	public void allProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			dao.AllProduct();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			allProduct();
		} // End of catch()
	}// End of allProduct

	public void allUser() {
		try {
		UserDao dao = UserFactory.getInstance();
		String type = "user";
		dao.AllUser(type);
		}catch(Exception e) {
			System.out.println("Something went wrong");
			allUser();
		}//End of allUser()
	}// End of allUser()

	public void deleteUser() {
		try {
		UserDao dao = UserFactory.getInstance();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter UserId");
//		int userId = Integer.parseInt(sc.nextLine());
		valid = true;
		while (valid) {
			System.out.println("Enter User Id");
			String userIdR = sc.nextLine();
			try {
				userId = ExceptionHandling.numValidation(userIdR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while
		boolean isDeleted = dao.DeleteUser(userId);
		if (isDeleted) {
			System.out.println("User Deleted successfully");
		} else {
			System.out.println("Failed to delete User");
		} // End of else
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			deleteUser();
		}//End of deleteUser()
	}// End of deleteUser

}// End of Admin
