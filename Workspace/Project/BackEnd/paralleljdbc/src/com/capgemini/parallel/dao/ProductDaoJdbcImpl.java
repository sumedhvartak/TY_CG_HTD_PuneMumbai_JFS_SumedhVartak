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

import com.capgemini.parallel.beans.ProductBean;

public class ProductDaoJdbcImpl implements ProductDao {
	FileReader reader = null;
	Properties prop = null;
	ProductBean product = null;

	public ProductDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db1.properties");// reader
			prop = new Properties();// Properties
			prop.load(reader);// Loading reader inside properties
		} catch (Exception e) {
			e.getStackTrace();
		} // End of catch
	}// End of Constructor

	@Override
	public List<ProductBean> viewAllProduct() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("productq1"));) {
			List<ProductBean> list = new ArrayList<ProductBean>();
			if (rs != null) {
				while (rs.next()) {
					product = new ProductBean();
					product.setProductName(rs.getString(1));
					product.setProductId(rs.getInt(2));
					product.setProductType(rs.getString(3));
					product.setProductPrice(rs.getInt(4));
					System.out.println("---------------------------------------------------");
					System.out.println("The ProductName = " + rs.getString(1));
					System.out.println("The ProductId = " + rs.getInt(2));
					System.out.println("The Product Type = " + rs.getString(3));
					System.out.println("The Product Price = " + rs.getInt(4));
					System.out.println();
					list.add(product);
				} // End of while()
				return list;
			} else {
				return null;
			} // End of else
		} catch (Exception e) {
			e.getStackTrace();
		} // End of catch()
		return null;
	}// End of viewAllProduct()

	@Override
	public boolean addProduct(String productName, int productId, String productType, int productPrice) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addproduct"));) {

			pstmt.setString(1, productName);
			pstmt.setInt(2, productId);
			pstmt.setString(3, productType);
			pstmt.setInt(4, productPrice);
			int rs = pstmt.executeUpdate();

			if (rs > 0) {
				return true;
			} else {
				return false;
			} // End of else
		} catch (Exception e) {
			// e.getStackTrace();
			System.out.println("The Product with this productId already exist");
		} // End of catch()
		return false;
	}// End of addProduct()

	@Override
	public boolean deleteProduct(int productId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
			 PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteproduct"));) {
			pstmt.setInt(1, productId);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Something went wrong in deleting product");
		} // End of catch()
		return false;
	}// End of deleteProduct()

	@Override
	public boolean updateProduct(int productId, int productPrice) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateproduct"));) {

			pstmt.setInt(1, productPrice);
			pstmt.setInt(2, productId);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			} // End of else
		} catch (Exception e) {
			System.out.println("Please enter valid ProductId");
		} // End of catch()
		return false;
	}// End of updateProduct

}// End of Main class
