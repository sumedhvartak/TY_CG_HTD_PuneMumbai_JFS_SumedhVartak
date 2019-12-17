package com.capgemini.parallelrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.parallelrest.beans.MessageBean;
import com.capgemini.parallelrest.beans.UserBean;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addMessage(int userId, String message, String type, String question) {
		UserBean userBean = null;
		MessageBean messageBean = new MessageBean();
		boolean isAdded = false;
		try {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		messageBean.setUserId(userId);
		messageBean.setMessage(message);
		messageBean.setType(type);
		messageBean.setQuestion(question);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(messageBean);
		transaction.commit();
		entityManager.close();
		isAdded = true;
		return isAdded;
		}catch(Exception e) {
			e.printStackTrace();
			return isAdded;
		}//End of catch()
		
	}//End of addMessage()

	@Override
	public List<MessageBean> showAllMessage() {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from MessageBean");
			List<MessageBean> list  = query.getResultList();
			if(list.isEmpty()) {
				return null;
			}else {
				return list;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}//End of showAllMessage()

	@Override
	public List<MessageBean> showAllMessage(int userId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from MessageBean where userId=:userid");
			query.setParameter("userid", userId);
			List<MessageBean> list  = query.getResultList();
			if(list.isEmpty()) {
				return null;
			}else {
				return list;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}//End of catch()
	}//End of showAllMessage()

	@Override
	public boolean addMessageAdmin(int userId, String message, String type) {
		//String type = "Response";
		
		boolean isAdded = false;
		MessageBean messageBean = new MessageBean();
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			messageBean.setUserId(userId);
			messageBean.setMessage(message);
			messageBean.setType(type);
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(messageBean);
			isAdded = true;
			transaction.commit();
			entityManager.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			isAdded = false;
		}
		return isAdded;
	}//End of addMessage()
	

}//End of MessageDaoImpl
