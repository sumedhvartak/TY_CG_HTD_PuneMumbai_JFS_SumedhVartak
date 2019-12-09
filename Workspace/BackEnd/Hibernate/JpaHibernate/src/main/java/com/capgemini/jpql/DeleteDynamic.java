package com.capgemini.jpql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDynamic
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "DELETE FROM  Movie  where id =:nm";
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Query query = em.createQuery(jpql);
		query.setParameter("nm", sc.nextInt() );
		int result = query.executeUpdate();
		System.out.println("Result " + result);
		transaction.commit();
	}

}
