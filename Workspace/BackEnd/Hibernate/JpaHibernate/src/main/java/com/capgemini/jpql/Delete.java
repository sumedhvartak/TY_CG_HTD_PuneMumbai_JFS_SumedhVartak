package com.capgemini.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete 
{

	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();

		String jpql = "DELETE FROM  Movie  where id = '2'";
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Query query = em.createQuery(jpql);
		int result = query.executeUpdate();
		System.out.println("Result " + result);
		transaction.commit();
	}
}
