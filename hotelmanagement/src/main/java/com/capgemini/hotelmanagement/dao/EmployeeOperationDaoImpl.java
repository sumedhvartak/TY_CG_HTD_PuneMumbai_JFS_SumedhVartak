package com.capgemini.hotelmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.BookingInformationBean;
import com.capgemini.hotelmanagement.beans.EmployeeInformationBean;
import com.capgemini.hotelmanagement.beans.HotelInformationBean;
import com.capgemini.hotelmanagement.beans.RoomInformationBean;
import com.capgemini.hotelmanagement.exception.HotelManagementSystemException;

@Repository
public class EmployeeOperationDaoImpl implements EmployeeOperationDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public HotelInformationBean getHotelInformation(String email) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql1 = "from EmployeeInformationBean where email = : email";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("email", email);
		EmployeeInformationBean employeeInformation = (EmployeeInformationBean) query1.getSingleResult();
		
		String jpql = "from HotelInformationBean where licenseNumber=:licenceNumber";
		HotelInformationBean hotelInfo = null;
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("licenceNumber", employeeInformation.getHotelLicense());
			hotelInfo = (HotelInformationBean) query.getSingleResult();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... hotel not found");
		}
		return hotelInfo;

	}// end of getHotelInformation()

	@Override
	public List<RoomInformationBean> getRoomList(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql1 = "from EmployeeInformationBean where email = : email";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("email", email);
		EmployeeInformationBean employeeInformation = (EmployeeInformationBean) query1.getSingleResult();
		String jpql = "from RoomInformationBean where hotelLicense=:licenceNumber";
		List<RoomInformationBean> roomlList = null;
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("licenceNumber", employeeInformation.getHotelLicense());
			roomlList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong... room list not found");
		}
		return roomlList;

	}// end of getRoomList()

	@Override
	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bookingInformationBean);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Something went wrong...cant book room now");
		}
		return bookingInformationBean;
	}

}// end of class
