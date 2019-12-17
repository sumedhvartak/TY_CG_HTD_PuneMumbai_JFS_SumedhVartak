package com.capgemini.parallel.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.parallel.beans.ProductBean;
import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.dao.ProductDao;
import com.capgemini.parallel.dao.UserDao;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;
import com.capgemini.parallel.factory.ProductFactory;
import com.capgemini.parallel.factory.UserFactory;

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


	public void addProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();

//			System.out.println("Enter ProductName");
//			String productName = sc.nextLine();
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

//			System.out.println("Enter ProductType ");
//			String productType = sc.nextLine();
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

			
//			System.out.println("Enter ProductPrice");
//			int productPrice = Integer.parseInt(sc.nextLine());
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

			boolean added = dao.addProduct(productName, productId, productType, productPrice);
			if (added) {
				System.out.println("Product Succcessfully Added");
			} else {
				System.out.println("Product Failed to add");
			}
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			addProduct();
		} // End of catch()
	}// End of main method

	public void viewAllProductMethod() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			List<ProductBean> list = dao.viewAllProduct();
			if (list != null) {
				System.out.println();
				System.out.println("Above the whole list is displayed");
			} else {
				System.out.println("Something went wrong");
			} // End of else
		} catch (Exception e) {
			System.out.println("Invalid Crdentials");
			viewAllProductMethod();
		} // End of catch()
	}// End of method

	public void deleteProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
//			System.out.println("Enter ProductId");
//			int productid = Integer.parseInt(sc.nextLine());
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

			boolean deleted = dao.deleteProduct(productId);
			if (deleted) {
				System.out.println("Product Deleted Successfully");
			} else {
				System.out.println("Product Failed to get Deleted");
			}
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			deleteProduct();
		}
	}// End of main method

	public void updateProduct() {
		try {
			ProductDao dao = ProductFactory.getInstance();
			Scanner sc = new Scanner(System.in);

//			System.out.println("Enter ProductId of a product inorder to update the price");
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

//			System.out.println("Enter ProductPrice");
//			int productPrice = Integer.parseInt(sc.nextLine());
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

			
			boolean update = dao.updateProduct(productId, productPrice);
			if (update) {
				System.out.println("Product Updated Successfully");
			} else {
				System.out.println("Product Failed to get Updated");
			} // End of else
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			updateProduct();
		} // End of catch()
	}// End of main method

	public void viewUser() {
		try {
			UserDao dao = UserFactory.getUserInstance();
			List<UserBean> view = dao.viewUser();
			if (view != null) {
				System.out.println("Above whole List of user is displayed");
//				for (UserBean va : view) {
//					// System.out.println(va);
//				}
			} // End of if block
		} catch (Exception e) {
			System.out.println("Something went wrong");
			viewUser();
		}
	}// End of method

	public void deleteUser() {
		try {
			UserDao dao = UserFactory.getUserInstance();
//			System.out.println("Enter UserId");
//			int userId = Integer.parseInt(sc.nextLine());
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
				System.out.println("User Deleted Successfully");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			System.out.println("Invalid Credential");
			deleteUser();
		} // End of catch()
	}// End of main method

	public void userRegister() {
		try {
			UserDao dao = UserFactory.getUserInstance();
//			System.out.println("Enter UserId");
//			int userid = Integer.parseInt(sc.nextLine());
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

//			System.out.println("Enter UserName");
//			String username = sc.nextLine();
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

//			System.out.println("Enter Email Id ");
//			String email = sc.nextLine();
//			System.out.println("Enter password");
//			String password = sc.nextLine();
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

			boolean added = dao.registerUser(userId, userName, email, password);
			if (added) {
				System.out.println("User is added successfully");
			} else {
				System.out.println("Failed to Add ");
			} // End of else
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			userRegister();
		} // End of catch()
	}// End of userRegister

	public void changePassword() {
		try {
			UserDao dao = UserFactory.getUserInstance();
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter UserId");
//			int userId = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter Password");
//			String password = sc.nextLine();
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
				System.out.println("Enter Password");
				String passR = sc.nextLine();
				try {
					password = ExceptionHandling.passValidation(passR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while()

			boolean changePassword = dao.changePassword(password, userId);
			if (changePassword) {
				System.out.println("Password changed successfully");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			changePassword();
		}
	}// End of method

}// End of AdminModuleMethod
