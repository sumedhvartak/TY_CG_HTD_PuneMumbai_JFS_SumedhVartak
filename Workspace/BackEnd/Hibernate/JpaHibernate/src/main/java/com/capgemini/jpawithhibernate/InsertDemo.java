package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.dto.Movie;

public class InsertDemo 
{
	public static void main(String[] args) 
	{
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		Movie movie = new Movie();
		movie.setId(4);
		movie.setName("ABC");
		movie.setRating("good");
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(movie);
			System.out.println("Record saved");
			transaction.commit();
		} catch (Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}
		
			entityManager.close();
		
	}

}
