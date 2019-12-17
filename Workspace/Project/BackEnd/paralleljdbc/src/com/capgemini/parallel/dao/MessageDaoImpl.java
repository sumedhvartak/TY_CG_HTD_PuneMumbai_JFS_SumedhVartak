package com.capgemini.parallel.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.capgemini.parallel.beans.MessageBean;

public class MessageDaoImpl implements MessageDao{
	FileReader reader = null;
	Properties prop = null;
	MessageBean messageBean = null;
	
	
	 public MessageDaoImpl() {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db1.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}//End of catch block
		
	}//End of MessageDaoImpl()
	

	@Override
	public MessageBean sendMessage(int messageId,int userId, String message, String type, String ask) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("message"));)
		{
			pstmt.setInt(1, messageId);
			pstmt.setInt(2, userId);
			pstmt.setString(3, message);
			pstmt.setString(4, type);
			pstmt.setString(5, ask);
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				System.out.println("Message sent");
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch()
		return null;
	}//End of sendMessage()


	@Override
	public MessageBean getMessage() {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl1"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("messageget"));)
		{
			if(rs!=null) {
				while(rs.next()) {
					messageBean = new MessageBean();
					messageBean.setMessageId(rs.getInt(1));
					messageBean.setUserId(rs.getInt(2));
					messageBean.setMessage(rs.getString(3));
					messageBean.setType(rs.getString(4));
					messageBean.setAsk(rs.getString(5));
					System.out.println();
					System.out.println("***********************************");
					System.out.println("The MessageId: " + rs.getInt(1));
					System.out.println("The UserId: " + rs.getInt(2) );
					System.out.println("Message: " + rs.getString(3));
					System.out.println("User/Admin: " + rs.getString(4));
					System.out.println("Response/Query: " + rs.getString(5));
					System.out.println("***********************************");
					System.out.println();
				}
				return messageBean;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}//End of getMessage()
	
	

}//End of MessageDaoImpl
