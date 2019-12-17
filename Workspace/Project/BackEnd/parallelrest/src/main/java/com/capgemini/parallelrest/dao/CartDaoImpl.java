package com.capgemini.parallelrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.parallelrest.beans.CartBean;
import com.capgemini.parallelrest.beans.ProductBean;
import com.capgemini.parallelrest.beans.UserBean;

@Repository
public class CartDaoImpl implements CartDao {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public CartBean addCart(int productId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			Query query1 = entityManager.createQuery("from ProductBean where productId=:productid");
			query1.setParameter("productid", productId);
			ProductBean productBean = (ProductBean) query1.getSingleResult();
			String productName = productBean.getProductName();
			int productPrice = productBean.getProductPrice();
			
			CartBean cartBean = new CartBean();
			cartBean.setProductId(productId);
			cartBean.setProductName(productName);
			cartBean.setProductPrice(productPrice);
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(cartBean);
			transaction.commit();
			entityManager.close();
			System.out.println("Product Added to Cart");
			return cartBean;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}//End of catch()
	}//End of addCart()

	@Override
	public List<CartBean> showCart() {
		List<CartBean> cartBean = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from CartBean");
			 cartBean = query.getResultList();
			 if(cartBean.isEmpty()) {
				 return cartBean;
			 }else {
				 return cartBean;
			 }//End of cartBean
		}catch(Exception e) {
			e.printStackTrace();
			return cartBean;
		}//End of catch()
		
	}//End of showCart()

	@Override
	public boolean deleteCart(int cartId) {
		boolean isDeleted = false;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("delete from CartBean where cartId=:cartid");
			query.setParameter("cartid", cartId);
			int rs = query.executeUpdate();
			if(rs>0) {
				isDeleted = true;
				transaction.commit();
				entityManager.close();
				return isDeleted;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return isDeleted;
		}//End of catch()
		return isDeleted;
	}//End of deleteCart()

	@Override
	public boolean deleteAllCart() {
		boolean isAllDeleted = false;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("delete from CartBean");
			int rs = query.executeUpdate();
			if(rs>0) {
				transaction.commit();
				entityManager.close();
				isAllDeleted = true;
				return isAllDeleted;
			}else {
				return isAllDeleted;
			}	
		}catch(Exception e) {
			e.printStackTrace();
			return isAllDeleted;
		}//End of catch()
	}//End of deleteAllCart()

	@Override
	public long totalBill() {
		long total = 0;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("SELECT sum(productPrice) FROM CartBean");
			
			total =  (long) query.getSingleResult();
			
		}catch(Exception e) {
				
		}//End of totalBill
		return total;
	}//End of totalBill()

}//End of CartDaoImpl
