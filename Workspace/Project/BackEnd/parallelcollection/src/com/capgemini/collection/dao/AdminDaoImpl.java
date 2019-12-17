package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.collection.bean.AdminBean;

public class AdminDaoImpl implements AdminDao {

	public static List<AdminBean> adminList;
	AdminBean adminBean = null;

	static {
		adminList = new ArrayList<AdminBean>();
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminId(2019001);
		adminBean.setAdminName("sam");
		adminBean.setEmailId("sam@gmail.com");
		adminBean.setPassword("samurai");
		adminBean.setType("Admin");

		AdminBean adminBean1 = new AdminBean();
		adminBean1.setAdminId(2019002);
		adminBean1.setAdminName("india");
		adminBean1.setEmailId("india@gmail.com");
		adminBean1.setMobileNo(12345678);
		adminBean1.setPassword("myindia");
		adminBean1.setType("User");

		AdminBean adminBean2 = new AdminBean();
		adminBean2.setAdminId(2019003);
		adminBean2.setAdminName("cristiano");
		adminBean2.setEmailId("cristiano@gmail.com");
		adminBean2.setMobileNo(123456);
		adminBean2.setPassword("ronaldo");
		adminBean2.setType("User");

		adminList.add(adminBean);
		adminList.add(adminBean1);
		adminList.add(adminBean2);

	}// End of static

	@Override
	public AdminBean login(String emailId, String password) {
		try {
			for (AdminBean admin : adminList) {
				if (admin.getEmailId().equals(emailId)) {
					if (admin.getPassword().equals(password)) {
						this.adminBean = admin;
					} // End of 2 if
				} // End of 1 if
			} // End of for()
			return adminBean;
		} catch (Exception e) {
			return adminBean;
		} // End of login()

	}// End of login

	@Override
	public AdminBean viewAllUser(String type) {
		try {
			for (AdminBean admin : adminList) {
				if (admin.getType().equals(type)) {
					System.out.println("");
					System.out.println("*********************************");
					System.out.println("The User Id: " + admin.getAdminId());
					System.out.println("The User Name: " + admin.getAdminName());
					System.out.println("The User EmailId: " + admin.getEmailId());
					System.out.println("The User Phone no. " + admin.getMobileNo());
					System.out.println("*********************************");
					System.out.println();
					this.adminBean = admin;
				} // End of if
					// return adminBean;Do not use return statement inside if block or for each loop
					// because in case of if block
					// it will return only 1 loop of output and in case of for each it will return
					// null
			} // End of for each
			return adminBean;
		} catch (Exception e) {
			System.out.println("Failed to display List");
		} // End of catch()
		return adminBean;
	}// End of viewAllUser()

	@Override
	public AdminBean registerUser(int id, String name, String emailId, int mobileNo, String password, String type) {
		boolean addUser = false;
		try {
			AdminBean adminBean = new AdminBean();
			for (AdminBean bean : adminList) {
				if (bean.getAdminId() == id) {
					addUser = true;
					System.out.println("Sorry for inconvenience");
					System.out.println("This User Id is already taken by someone ");
					System.out.println("Please Enter other User Id");
					this.adminBean = null;
					return adminBean;
				}
			} // End of for each
			if (!addUser) {

				adminBean.setAdminId(id);
				adminBean.setAdminName(name);
				adminBean.setEmailId(emailId);
				adminBean.setMobileNo(mobileNo);
				adminBean.setPassword(password);
				adminBean.setType(type);
				adminList.add(adminBean);
				System.out.println();
				System.out.println("*********************************");
				System.out.println("The User Id:          " + adminBean.getAdminId());
				System.out.println("The User Name:        " + adminBean.getAdminName());
				System.out.println("The User Email Id :   " + adminBean.getEmailId());
				System.out.println("The User Mobile No.:  " + adminBean.getMobileNo());
				System.out.println("The Type :            " + adminBean.getType());
				System.out.println("*********************************");
				System.out.println();
				//System.out.println("User Added successfully");
			} // End of if block
			return adminBean;
		} catch (Exception e) {
			return adminBean;
		} // End of catch()
	}// End of registerUser()

	@Override
	public boolean deleteUser(int id) {
		boolean delete = false;
		try {
			for (AdminBean admin : adminList) {
				if (id == admin.getAdminId()) {
					adminList.remove(admin);
					delete = true;
					return delete;
				} // End of if
				else {
					delete = false;
				} // End of else
			} // End of for each
		} catch (Exception e) {
			delete = false;
		} // End of catch()
		return delete;
	}// End of deleteUser()

	@Override
	public boolean changePassword(int id, String password) {
		boolean changePassword = false;
		try {
			for (AdminBean admin : adminList) {
				if (admin.getAdminId() == id) {
					admin.setPassword(password);
					// adminList.add(admin); do not do this it will lead to addition of extra new
					// object in array
					System.out.println("");
					System.out.println("********************************");
					System.out.println("Successfully Updated");
					System.out.println("The User Id:    " + admin.getAdminId());
					System.out.println("The User Name:  " + admin.getAdminName());
					System.out.println("The User Email: " + admin.getEmailId());
					System.out.println("The Type:       " + admin.getType());
					System.out.println("Please Do not share your Password");
					System.out.println("********************************");
					System.out.println();
					changePassword = true;
					return changePassword;
				} else {
					changePassword = false;
				} // End of else
			} // End of for
		} catch (Exception e) {
			changePassword = false;
		} // End of catch()
		return changePassword;
	}// End of updateUser

}// End of AdminDaoImpl
