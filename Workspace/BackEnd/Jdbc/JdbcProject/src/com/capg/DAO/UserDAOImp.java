package com.capg.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.capg.BeanClass.Bean;

public class UserDAOImp implements UserDAO 
{
	Connection conn = null;
	Scanner sc= new Scanner(System.in);
	Bean bean;
	Statement stmt =null;

	public UserDAOImp()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("............Driver Loaded..................");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public Bean getall() 
	{
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?user=root&password=root");
			String query = "Select * from sumedh";
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
//				hotel = new Hotelinfo();
//				hotel.setItem_code(rs.getInt(1));
//				hotel.setFood_name(rs.getString(2));
//				hotel.setPrice(rs.getDouble(3));
				System.out.println("Item COde = " + rs.getInt(1));
				System.out.println("Food Name = " + rs.getString(2));
				System.out.println("Price     = " + rs.getDouble(3));
			} // end of while

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Bean getorder(int item_code) 
	{
		try {
			String dburl = "jdbc:mysql://localhost:3306/movie?user=root&password=root";
			conn = DriverManager.getConnection(dburl);

			String query = "select * from sumedh where Item_code = ?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, item_code);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
//					
					int ab = rs.getInt(1);
					System.out.println("your food Item code is =" + ab);
					System.out.println("your food name is = " + rs.getString(2));
					System.out.println("price of that food is = " + rs.getDouble(3));
					
					if(ab == 101)
					{
						String query1 = "insert into consumernew values('101','Dosa','30')";
						stmt = conn.createStatement();
						stmt.executeUpdate(query1); 
					}else if(ab == 102)
					{
						String query1 = "insert into consumernew values('102','Mendu Vada','20')";
						stmt = conn.createStatement();
						stmt.executeUpdate(query1);
					}//end of case 102
					
					else if(ab == 103)
					{
						String query1 = "insert into consumernew values('103','Idli Vada','15')";
						stmt = conn.createStatement();
						stmt.executeUpdate(query1); 
					}//end of case 103
				}//end of if else											
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end of fisrt try

		catch (Exception e) {
			e.printStackTrace();
		} // end of first try catch

		return null;
	}//end of get order

}//end of main class
