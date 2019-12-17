package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.bean.ProductBean;
import com.capgemini.collection.dao.AdminDao;
import com.capgemini.collection.dao.ProductDao;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;
import com.capgemini.collection.factory.AdminFactory;
import com.capgemini.collection.factory.ProductFactory;

public class AdminModuleMethod {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	// Product
	static Integer productId;
	static Integer productPrice;
	static String productName;
	static String productType;

	// User
	static Integer userId;
	static String userName;
	static String email;
	static String password;
	static Integer mobile;

	public void addProduct(AdminBean adminBean) {
		try {
			ProductDao dao = ProductFactory.getInstance();
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
				System.out.println("Enter ProductName");
				String productNameR = sc.nextLine();
				try {
					productName = ExceptionHandling.productNameTypeVal(productNameR);
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
				System.out.println("Enter ProductType");
				String productTypeR = sc.nextLine();
				try {
					productType = ExceptionHandling.productNameTypeVal(productTypeR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
			
			
			ProductBean product = dao.addProduct(productId, productName, productType, productPrice);
			if (product != null) {
				System.out.println("Product Added successfully");
			} else {
				System.out.println("Failed to add Product");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credentials");
			addProduct(adminBean);
		} // End of catch()

	}// End of addProduct method

	public void deleteProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
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
			boolean product = dao.deleteProduct(productId);
			if (product) {
				System.out.println("Product Deleted");
			} else {
				System.out.println("Something went wrong");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			deleteProduct();
		} // End of catch()
	}// End of deleteProduct()

	public void updateProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
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
			System.out.println();
			ProductBean product = dao.updateProduct(productId, productPrice);
			if (product != null) {
				System.out.println("Product Updated");
			} else {
				System.out.println("It might happen that this product with productId do not exist in database");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			updateProduct();

		} // End of catch()

	}// End of updateProduct()

	public void viewAllProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			ProductBean productBean = dao.allProduct();
			if (productBean != null) {
				System.out.println("Above the list is displayed");
			} else {
				System.out.println("Failed to load the list");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			viewAllProduct();
		} // End of catch()
	}// End of viewAllProduct()

	// ******************************************************************************************************

	// User

	public void viewAllUser() {
		try {
			AdminDao dao = AdminFactory.getInstance();
			String type = "User";
			AdminBean adminBean = dao.viewAllUser(type);
			if (adminBean != null) {
				System.out.println("Above the list is displayed");
			} else {
				System.out.println("Failed to load the List");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			updateProduct();
		} // End of catch()
	}// End of viewAllUser()

	public void deleteUser() {
		try {
			AdminDao dao = AdminFactory.getInstance();
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
			}

			boolean delete = dao.deleteUser(userId);
			if (delete) {
				System.out.println("User deleted successfully");
			} else {
				System.out.println("Failed to delete Product");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			deleteUser();

		} // End of catch()

	}// End of deleteUser()

	public void register() {
		try {
			AdminDao dao = AdminFactory.getInstance();
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

			valid = true;
			while (valid) {
				System.out.println("Enter User Name");
				String userNameR = sc.nextLine();
				try {
					userName = ExceptionHandling.nameValidation(userNameR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			valid = true;
			while (valid) {
				System.out.println("Enter Email Id");
				String emailR = sc.nextLine();
				try {
					email = ExceptionHandling.emailValidation(emailR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while()

			valid = true;
			while (valid) {
				System.out.println("Enter Mobile no.");
				String mobileR = sc.nextLine();
				try {
					mobile = ExceptionHandling.numValidation(mobileR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of while()
			} // End of while()

			valid = true;
			while (valid) {
				System.out.println("Enter Password");
				String passR = sc.nextLine();
				try {
					password = ExceptionHandling.passValidation(passR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while()

			String type = "User";
			AdminBean adminBean = dao.registerUser(userId, userName, email, mobile, password, type);
			if (adminBean != null) {
				System.out.println("User Added successfully");
			} else {
				System.out.println("Failed to add User");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			register();
		} // End of catch()
	}// End of register()

	public void changePassword(AdminBean adminBean) {
		try {
			AdminDao dao = AdminFactory.getInstance();

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
			}

			valid = true;
			while (valid) {
				System.out.println("Enter Password");
				String passR = sc.nextLine();
				try {
					password = ExceptionHandling.passValidation(passR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while()

			boolean bean = dao.changePassword(userId, password);
			if (bean) {
				System.out.println("Password Updated");
			} else {
				System.out.println("Failed to Update Password");
			} // End of else
		} catch (Exception e) {
			System.out.println("You have entered Invalid Credential");
			changePassword(adminBean);

		} // End of catch()

	}// End of changePassword

}// End of AdminModuleNethod
