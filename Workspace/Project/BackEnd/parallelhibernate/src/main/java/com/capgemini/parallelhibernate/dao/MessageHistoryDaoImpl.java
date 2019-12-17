package com.capgemini.parallelhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.parallelhibernate.beans.CartBean;
import com.capgemini.parallelhibernate.beans.MessageHistory;
import com.capgemini.parallelhibernate.beans.UserBean;

public class MessageHistoryDaoImpl implements MessageHistoryDao{
	
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean insertCart(int userId, String userName) {
		try {
			UserBean userBean = new UserBean();
			CartBean cartBean = new CartBean();
			MessageHistory messageHistory = new MessageHistory();
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			Query query = entityManager.createQuery("from CartBean");
			cartBean = (CartBean) query.getSingleResult();
			messageHistory.setUserId(userId);
			messageHistory.setUserName(userName);
			messageHistory.setProductId(cartBean.getProductId());
			messageHistory.setProductName(cartBean.getProductName());
			messageHistory.setProductPrice(cartBean.getProductPrice());
			messageHistory.setProductQuantity(cartBean.getProductQuantity());
			entityManager.persist(messageHistory);
			transaction.commit();
			entityManager.close();
			return true;//Returning true if data is inserted
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch	
	}//End of insertCart

	@Override
	public boolean getCartInfo(int userId) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			Query query = entityManager.createQuery("from MessageHistory where userId=:userid");
			query.setParameter("userid", userId);
			if(query.getResultList().isEmpty()) {
				System.out.println("Eighter database is Empty");
			}else {
				List<MessageHistory> messageHis = query.getResultList();
				System.out.println("The List of all orders");
				for(MessageHistory hist : messageHis) {
					System.out.println("***************************************");
					System.out.println("The UserId: " + hist.getUserId());
					System.out.println("The UserNname: " + hist.getUserName());
					System.out.println("The ProductId: " + hist.getProductId());
					System.out.println("The ProductName: " + hist.getProductName());
					System.out.println("The ProductPrice: " + hist.getProductPrice());
					System.out.println("The ProductQuantity: " + hist.getProductQuantity());
				}//End of for each
				return true;
			}//End of else
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()
		return true;
	}//End of getCartInfo

	@Override
	public boolean getAllCartInfo() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("from MessageHistory");
			if(query.getResultList().isEmpty()) {
				System.out.println("Eighter database is Empty");
			}else {
				List<MessageHistory> messageHis = query.getResultList();
				System.out.println("The List of all orders");
				for(MessageHistory hist : messageHis) {
					System.out.println("***************************************");
					System.out.println("The UserId: " + hist.getUserId());
					System.out.println("The UserNname: " + hist.getUserName());
					System.out.println("The ProductId: " + hist.getProductId());
					System.out.println("The ProductName: " + hist.getProductName());
					System.out.println("The ProductPrice: " + hist.getProductPrice());
					System.out.println("The ProductQuantity: " + hist.getProductQuantity());
				}//End of for each
				return true;
			}//End of else()
		}catch(Exception e) {
			return false;
		}//End of catch()
		return false;
	}//End of getAllCartInfo
	
	
	

}//End of MessageHistoryDaoImpl
