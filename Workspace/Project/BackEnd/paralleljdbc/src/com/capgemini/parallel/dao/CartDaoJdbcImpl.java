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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.parallel.beans.ProductBean;

public class CartDaoJdbcImpl implements CartDao{
	FileReader reader  = null;
	Properties prop = null;
	ProductBean product = null;
	Scanner sc = new Scanner(System.in);
	
	
	
	 public CartDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db1.properties");
			prop = new Properties();
			prop.load(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}//End of Catch Block
	}//End of catch block

	@Override
	public boolean addProductCart(ProductBean productBean) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertcart"));
				){
			
			pstmt.setInt(1, productBean.getProductId());
			
			int rs = pstmt.executeUpdate();
			if(rs>0) {
				return true;
			}else{
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//End of Catch Block
		return false;
	}//End of addProductCart()
	

	@Override
	public boolean deleteProductCart(int productId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deletecart"));
				){
			pstmt.setInt(1, productId);
			int rs = pstmt.executeUpdate();
			if(rs>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch()
		return false;
	}//End of deleteProductCart()

	@Override
	public List<ProductBean> viewAllCart() {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("viewallcart"));){
			List<ProductBean> list = new ArrayList<ProductBean>();
			
			if(rs!=null) {
				while(rs.next()) {
					product = new ProductBean();
					product.setProductName(rs.getString(1));
					product.setProductId(rs.getInt(2));
					product.setProductType(rs.getString(3));
					product.setProductPrice(rs.getInt(4));
					System.out.println("---------------------------------------------------");
					System.out.println("The ProductName = " + rs.getString(1));
					System.out.println("The ProductId = " + rs.getInt(2));
					System.out.println("The Product Type = " + rs.getString(3));
					System.out.println("The Product Price = "+  rs.getInt(4));
					System.out.println();
					list.add(product);
					
				}//End of rs.next()	
				return list;
			}else {
				return null;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}//End of viewAllProduct()
		return null;
	}//End of viewAllCart()

	@Override
	public boolean deleteAllCart() {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteentirecart"));)
		{
			int rs = pstmt.executeUpdate();
			if(rs>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch()
		return false;
	}//End of deleteAllCart()

	@Override
	public boolean sum() {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("payment"));)
		{
			if(rs!=null) {
				while (rs.next()) {
					System.out.println("");
					System.out.println("Medicine Added To Cart Successfully");
					System.out.println(" total bill of your's is " + rs.getInt(1));
					System.out.println("");
				}
				return true;
			}else {
				return false;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch Block
		return false;
	}
	
	

}//End of CartDaoJdbcImpl
