package com.capgemini.parallelhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.parallelhibernate.beans.MessageBean;

public class MessageDaoImpl implements MessageDao{
	
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;
	
	@Override
	public boolean addMessage(int userId, String message, String type, String ask) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			MessageBean messageBean = new MessageBean();
		//	messageBean.setMessageId(messageId);
			messageBean.setUserId(userId);
			messageBean.setMessage(message);
			messageBean.setType(type);
			messageBean.setAsk(ask);
			entityManager.persist(messageBean);
			transaction.commit();
			entityManager.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}//End of addMessage()

	@Override
	public boolean getMessage(int userId) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("from MessageBean where userId=:userid");
		//	int user = messageBean.getUserId();
			query.setParameter("userid", userId);
			if(query.getResultList().isEmpty()) {
				System.out.println("Something has went wrong");
			}else {
				List<MessageBean> message = query.getResultList();
				for(MessageBean msg : message) {
					System.out.println("The MessageId: " + msg.getMessageId());
					System.out.println("The UserId: " + msg.getUserId());
					System.out.println("The Message: " + msg.getMessage());
				}
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()
		//return false;
		return true;
	}//End of getMessage

	@Override
	public boolean getAllMessage() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("from MessageBean");
			if(query.getResultList().isEmpty()) {
				System.out.println("Something has went wrong");
			}else {
				List<MessageBean> message = query.getResultList();
				System.out.println("The List of all your sent Messages---");
				for(MessageBean msg : message) {
					System.out.println("*****************************************");
					System.out.println("The MessageId: " + msg.getMessageId());
					System.out.println("The UserId: " + msg.getUserId());
					System.out.println("The Message: " + msg.getMessage());
					System.out.println("The Type of User: " + msg.getType());
					System.out.println("The Type of question: " + msg.getAsk());
					System.out.println();
				}//End of for each
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()
		return true;
	}//End of getAllMessage()

	
}//End of MessageDaoImpl
