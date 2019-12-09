package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemin.onetoone.Person;
import com.capgemin.onetoone.Votercard;
import com.capgemini.jpawithhibernate.dto.Movie;

public class TestOnetoone {

	public static void main(String[] args) 
	{
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		Person person = new Person();
		person.setId(1);
		person.setName("Sumedh");
		person.setPid(10234);

		Votercard votercard = new Votercard();
		votercard.setAddress("J P Nagar");
		votercard.setVoter_id(1);
		person.setVotercard(votercard);
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
