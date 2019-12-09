package com.capg.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class JDBCretrieval 
{

	public static void main(String[] args) 
	{
		Connection conn = null;
		FileReader  reader;
		Properties prop = null;
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

			//Get the Connection
			String dbUrl = prop.getProperty("dbUrl");
			conn = DriverManager.getConnection(dbUrl, prop.getProperty("user"),prop.getProperty("password"));
			System.out.println("Connection Established");
			System.out.println("*****************************");


			//Issue SQL Query
			String query = "SELECT * FROM users_info where Userid = ?";
			pstmt = conn.prepareStatement(query);
			System.out.println("Enter Userid");
			pstmt.setInt(1,sc.nextInt());
			rs = pstmt.executeQuery(); //result set is boolean.



			//Process the result
			if(rs.next())
			{
				System.out.println();
				System.out.println("Userid:" + rs.getInt(1));
				System.out.println("Username:" + rs.getString(2));
				System.out.println("User Email:" + rs.getString(3));
				System.out.println("Password:"+ rs.getString(4));
			}
			else
			{
				System.out.println("Something went wrong");
			}


		}catch(Exception e)
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
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		sc.close();


	}

}
