package com.capgemini.jpawithhibernate;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.manytomany.Course;
import com.capgemini.manytomany.Student;

public class ManytoMany
{

	public static void main(String[] args)
	{
		EntityTransaction t = null;
		
		Course c1 = new Course();
		c1.setCid(1);
		c1.setCname("Java");
		
		Course c2 = new Course();
		c2.setCid(2);
		c2.setCname("SQL");
		
		
		ArrayList<Course> alist = new ArrayList<Course>();
		alist.add(c1);
		alist.add(c2);
		
		Student s1 = new Student();
		s1.setSid(101);
		s1.setSname("Rahul");
		s1.setCourse(alist);
		
		
		
			try {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
				EntityManager em = emf.createEntityManager();
				t = em.getTransaction();
				t.begin();
				//em.persist(s1);//by student
				Course course2 = em.find(Course.class, 1);//by course
				course2.getStudent().get(0).getSid();
				t.commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				t.rollback();
			}
		
	}

}
