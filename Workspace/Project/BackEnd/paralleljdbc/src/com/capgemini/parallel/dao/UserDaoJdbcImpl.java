package com.capgemini.parallel.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.parallel.beans.UserBean;

public class UserDaoJdbcImpl implements UserDao {
	FileReader reader = null;
	Properties prop = null;
	UserBean user = null;
	Scanner sc = new Scanner(System.in);

	// Constructor
	public UserDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db1.properties");
			prop = new Properties();
			prop.load(reader);// Loading reader inside properties
		} catch (Exception e) {
			e.printStackTrace();
		} // End of Catch Block
	}// End of Constructor

	@Override
	public boolean registerUser(int userid, String username, String email, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"));) {

			pstmt.setInt(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			} // End of else
		} catch (Exception e) {
			System.out.println("User with this ProductId already Exist");
		} // End of catch()
		return false;
	}// End of registerUser

	@Override
	public UserBean login(String email, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("userlogin"));) {
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					user = new UserBean();
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setEmailId(rs.getString(3));
					user.setPassword(rs.getString(4));
					user.setType(rs.getString(5));
				}//End of if
				return user;
			} else {
				return null;
			}//End of else
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Invalid Credentials");
		} // End of catch();
		return null;
	}

	@Override
	public boolean changePassword(String password, int userid) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("changepassworduser"));) {
			pstmt.setString(1, password);
			pstmt.setInt(2, userid);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Please enter your correct userid");
		} // End of catch
		return false;
	}// End of changePassword

	@Override
	public boolean deleteUser(int userid) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteUser"));) {
			pstmt.setInt(1, userid);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Please enter your correct userid");
//			e.printStackTrace();
		}//End of catch()
		return false;
	}// End of deleteUser()

	@Override
	public List<UserBean> viewUser() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("viewuser"));) {
			List<UserBean> list = new ArrayList<UserBean>();
			System.out.println("The list of all User is displayed");
			System.out.println();
			if (rs != null) {
				while (rs.next()) {
					user = new UserBean();
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setEmailId(rs.getString(3));
					user.setPassword(rs.getString(4));
					user.setType(rs.getString(5));
					System.out.println("UserId = " + rs.getInt(1));
					System.out.println("UserName = " + rs.getString(2));
					System.out.println("EmailId = " + rs.getString(3));
					System.out.println("Password = " + rs.getString(4));
					System.out.println("--------------------------------------------");
					System.out.println();
					list.add(user);
				} // End of while()
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("None UserInfo exist in your database");
		} // End of catch Block
		return null;
	}// End of viewUser()

}// End of UserDaoJdbcImpl
