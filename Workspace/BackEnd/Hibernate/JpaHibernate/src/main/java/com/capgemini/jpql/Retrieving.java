package com.capgemini.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpawithhibernate.dto.Movie;

public class Retrieving {

	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		String jpql = "from Movie";
		Query query = em.createQuery(jpql);
		List<Movie> data = query.getResultList();
		
		for(Movie movie : data)
		{
			System.out.println(movie.getId());
		}
		em.close();
	}///end of main method

}//end of main class
