package com.capgemini.parallelrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.parallelrest.beans.UserBean;

@Repository
public class UserBeanDaoImpl implements UserBeanDao{
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public UserBean userLogin(String email, String password) {
		EntityManager entityManager = null;
		UserBean userBean = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from UserBean where email=:email and password=:password");
			query.setParameter("email", email);//set email
			query.setParameter("password", password);//set password
			userBean = (UserBean) query.getSingleResult();
			return userBean;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}//End of catch
	}//End of userLogin()

	
	@Override
	public UserBean addUser(UserBean userBean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.persist(userBean);
			transaction.commit();
			entityManager.close();
			return userBean;
			
		}catch(Exception e) {
			System.out.println("Failed to register");
			return null;
		}//End of catch()
	}//End of addUser()


	@Override
	public List<UserBean> showAllUser() {
		EntityManager entityManager  = null;
		List<UserBean> data = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from UserBean");
			data = query.getResultList();
			entityManager.close();
			return data;
		}catch(Exception e) {
			System.out.println("Failed to load the list");
			return null;
		}//End of 
		
	}//End of showAllUser()


	@Override
	public UserBean getUser(int userId) {
		EntityManager entityManager = null;
		UserBean userBean = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from UserBean where userId=:userid");
			query.setParameter("userid", userId);
			userBean = (UserBean) query.getSingleResult();
			entityManager.close();
			return userBean;
		}catch(Exception e) {
			System.out.println("Failed to login");
			return null;
		}//End of catch()
	}//End of getUser()


	@Override
	public boolean removeUser(int userId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("delete from UserBean where userId=:userid");
			query.setParameter("userid", userId);
			int rs = query.executeUpdate();
			if(rs>0) {
				transaction.commit();
				entityManager.close();
				return true;
			}else {
				return false;
			}	
		}catch(Exception e) {
			System.out.println("Failed to remove user");
			return false;
		}//End of catch()
	}//End of removeUser()


	@Override
	public boolean updateUser(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		UserBean update = entityManager.find(UserBean.class, userBean.getUserId());
		
		if(update!=null) {
//			int userId = userBean.getUserId();
//			if(userId>0) {
//				update.setUserId(userId);
//			}
//				
//			String userName = userBean.getUserName();
//			if(userName!=null) {
//				update.setUserName(userName);
//			}
//			
//			String email = userBean.getEmail();
//			if(email!=null) {
//				update.setEmail(email);
//			}
			String password = userBean.getPassword();
			if(password!=null) {
				update.setPassword(password);
			}
		}//End of if
		
		try {
			transaction.begin();
			entityManager.persist(update);
			transaction.commit();
			entityManager.close();
			return true;
		}catch(Exception e) {
			System.out.println("Failed to update user");
			return false;
		}//End of Catch()
	}//End of updateUser()

}//End of UserBeanDaoImpl
