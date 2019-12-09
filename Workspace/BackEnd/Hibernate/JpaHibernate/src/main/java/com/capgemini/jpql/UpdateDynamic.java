package com.capgemini.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateDynamic {

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "update Movie set name =:nm where id =:mid";
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Query query = em.createQuery(jpql);
		
		query.setParameter("nm", "Dhoom");
		query.setParameter("mid", 1);
		int result = query.executeUpdate();
		System.out.println("Result " + result);
		transaction.commit();
	}

}

