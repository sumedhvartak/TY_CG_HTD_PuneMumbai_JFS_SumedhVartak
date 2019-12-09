package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.dto.Movie;

public class Reatching 
{
	public static void main(String[] args) 
	{
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		
		
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Movie data = entityManager.find(Movie.class, 1);
			System.out.println(entityManager.contains(data));
			entityManager.detach(data);
			System.out.println(entityManager.contains(data));
			Movie movie = entityManager.merge(data);
			movie.setName("Congo");
			transaction.commit();
			
		} catch (Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}
			entityManager.close();
	}//end of main method
}//end of main class
	


