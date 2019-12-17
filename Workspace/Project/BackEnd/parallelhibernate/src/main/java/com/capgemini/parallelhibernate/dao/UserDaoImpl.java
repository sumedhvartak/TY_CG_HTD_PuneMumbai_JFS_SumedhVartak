package com.capgemini.parallelhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.controller.AdminModule;
import com.capgemini.parallelhibernate.controller.UserModule;

public class UserDaoImpl implements UserDao {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;
	UserBean userBean = null;

	@Override
	public boolean loginUser(String email, String password) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from UserBean where emailId=:email and password=:pass";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("pass", password);
			if (query.getResultList().isEmpty()) {
				System.out.println("You have entered Invalid credentials");
				return false;
			} else {
				List<UserBean> user = query.getResultList();
				for (UserBean res : user) {
					System.out.println("You have successfully Logged in!....");
					System.out.println("Welcome " + res.getUserName());
					System.out.println("Type of user: " + res.getType());
					if(res.getType().equals("user")) {
						new UserModule().userModule(res);
						break;
					}else if(res.getType().equals("admin")) {
						new AdminModule().adminModule(res);
						break;
					}else {
						System.out.println("Something is wrong");
					}//End of nested if	
				}//End of for each
				return true;
			} // End of else()
		} catch (Exception e) {
			e.printStackTrace();
		} // End of catch()
		return true;
	}// End of loginUser()

	@Override
	public boolean register(UserBean userBean) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(userBean);
			//System.out.println("You have Registered Successfully");
			transaction.commit();
			return true;
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Please Use Unique UserId. It is already Taken by someone.");
			System.out.println("**********************************************************");
			return false;
		}//End of catch()
	}//End of register()
	
	
	@Override
	public void AllUser(String type) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from UserBean where type=:utype");
			query.setParameter("utype", type);
			List<UserBean> userBean = query.getResultList();
			System.out.println("The List of all User-");
			for(UserBean user : userBean) {
				System.out.println("*************************");
				System.out.println("The UserId: " + user.getUserId());
				System.out.println("The UserName: " + user.getUserName());
				System.out.println("The User EmailId: " + user.getEmailId());
				System.out.println();
			}//End of UserBean
			System.out.println();	
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}//End of AllUser()

	@Override
	public boolean DeleteUser(int userId) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("Delete from UserBean where userId=:userid");
			query.setParameter("userid", userId);
			int rs = query.executeUpdate();
			if(rs>0) {
				System.out.println("User Deleted successfully");
				transaction.commit();
				entityManager.close();
				return true;
			}else {
				System.out.println("You have Invalid UserId");
				return false;
			}//End of else
			
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Something is going wrong");
		}//End of catch()
		return false;
	}//End of DeleteUser()

	@Override
	public boolean changePassword(int userId, String password, String emailId) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("update UserBean set password=:pass where UserId=:userid and emailId=:email");
			query.setParameter("pass", password);
			query.setParameter("userid", userId);
			query.setParameter("email", emailId);
			int rs = query.executeUpdate();
			if(rs>0) {
				System.out.println("Password Updated Successfully");
				Query query1 = entityManager.createQuery("from UserBean where UserId=: userid");
				query1.setParameter("userid", userId);
				List<UserBean> userBean = query1.getResultList();
				System.out.println("The Updated User Info:");
				for(UserBean user : userBean) {
					System.out.println();
					System.out.println("*********************************");
					System.out.println("The UserId " + user.getUserId());
					System.out.println("The UserName " + user.getUserName());
					System.out.println("The User EmailId " + user.getEmailId());
					System.out.println("The Password: " + user.getPassword());
					System.out.println("Please Do Not share your password");
					System.out.println();
				}//End of for each
				transaction.commit();
				entityManager.close();
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()
		
	}//End of changePassword()
	
}// End of UserDaoImpl
