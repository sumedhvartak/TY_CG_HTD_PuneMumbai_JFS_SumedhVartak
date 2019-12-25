package com.capgemini.hotelmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.AdminEmployeeUserBean;
import com.capgemini.hotelmanagement.exception.HotelManagementSystemException;


@Repository
public class AdminEmployeeUserDaoImpl implements AdminEmployeeUserDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public AdminEmployeeUserBean getLogin(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AdminEmployeeUserBean where email = :email and password =: password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		AdminEmployeeUserBean user = null;
		try {
			user = (AdminEmployeeUserBean) query.getSingleResult();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Invalid login credentials");
		}
		return user;
	}

	@Override
	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(userBean);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("User already exists");
		}
		return userBean;
	}
}
