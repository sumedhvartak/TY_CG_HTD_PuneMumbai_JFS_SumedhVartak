package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.onrtomany.Pencil;
import com.capgemini.onrtomany.Pencilbox;

public class ManytoOne {

	public static void main(String[] args)
	{
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		Pencilbox pencilbox = new Pencilbox();
		pencilbox.setName("Flora");
		pencilbox.setBoxid(4);
		
		
		  Pencil pencil = new Pencil();
		  pencil.setColor("Pink");
		  pencil.setPid(107);
		  pencil.setPencilBox(pencilbox);
		 
		
		
		  Pencil pencil1 = new Pencil();
		  pencil1.setColor("Pink-White");
		  pencil1.setPid(45);
		  pencil1.setPencilBox(pencilbox);
		 
				try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(pencil);
			entityManager.persist(pencil1);
			/*
			 * carddetail = entityManager.find(Votercard.class, 1);
			 * System.out.println(carddetail.getVoter_id());
			 * System.out.println(carddetail.getAddress());
			 * System.out.println(carddetail.getPerson().getName());
			 * System.out.println(carddetail.getPerson().getPid());
			 * System.out.println("Record saved");
			 */transaction.commit();
		} catch (Exception e) 
		{
			
			e.printStackTrace();
			transaction.rollback();
		}

		entityManager.close();


	}

}
