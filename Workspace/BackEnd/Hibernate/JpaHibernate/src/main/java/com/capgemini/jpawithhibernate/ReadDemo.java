package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.dto.Movie;

public class ReadDemo
{

	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Movie data = entityManager.find(Movie.class, 2);
		System.out.println(data.getId());
		System.out.println(data.getName());
		System.out.println(data.getRating());


	}

}
