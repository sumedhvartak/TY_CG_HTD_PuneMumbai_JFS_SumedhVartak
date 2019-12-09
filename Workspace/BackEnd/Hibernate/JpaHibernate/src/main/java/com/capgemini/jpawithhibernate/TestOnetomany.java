package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemin.onetoone.Person;
import com.capgemin.onetoone.Votercard;

public class TestOnetomany {

	public static void main(String[] args) 
	{
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			//entityManager.persist(person);
			Votercard carddetail = entityManager.find(Votercard.class, 1);
			System.out.println(carddetail.getVoter_id());
			System.out.println(carddetail.getAddress());
			System.out.println(carddetail.getPerson().getName());
			System.out.println(carddetail.getPerson().getPid());
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
