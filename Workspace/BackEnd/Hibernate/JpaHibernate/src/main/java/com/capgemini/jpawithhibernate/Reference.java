package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.dto.Movie;

public class Reference 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		  Movie data = entityManager.find(Movie.class, 1);
		  System.out.println(data.getId());
		 
		  //Comparing find and GetRefernce

		/*
		 * Movie movie = entityManager.getReference(Movie.class, 1);
		 * System.out.println(movie.getName());
		 */


	}
}
