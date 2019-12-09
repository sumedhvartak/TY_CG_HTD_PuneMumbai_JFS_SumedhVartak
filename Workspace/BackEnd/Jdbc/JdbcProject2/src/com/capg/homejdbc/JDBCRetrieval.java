package com.capg.homejdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBCRetrieval {

	public static void main(String[] args) 
	{
		FileReader reader;
		Properties prop = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;

		try 
		{
			reader = new FileReader("db1.properties");
			prop = new Properties();
			prop.load(reader);


		} catch (Exception e)
		{
			e.printStackTrace();
		}

		try
		{

			String dbUrl = prop.getProperty("dbUrl");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");

			conn = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connection Connected");
			System.out.println("***************************");

			String query ="select * from users_info where userid =?";
			pstmt = conn.prepareStatement(query);
			System.out.println("Enter userid in order to extract");
			pstmt.setInt(1,sc.nextInt());
				
			rs = pstmt.executeQuery();
			sc.close();
			if(rs.next())
			{
				System.out.println("UserId : " + rs.getInt(1));
				System.out.println("Username:" + rs.getString(2));
				System.out.println("User Email:" + rs.getString(3));
				System.out.println("Password:"+ rs.getString(4));
			}
			else
			{
				System.out.println("Something went wrong");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if(conn!=null)
			{
				try 
				{
					conn.close();
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(rs!= null)
			{
				try 
				{
					rs.close();
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		

	}

}
