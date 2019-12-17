package com.capgemini.parallelhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.parallelhibernate.beans.CartBean;
import com.capgemini.parallelhibernate.beans.ProductBean;

public class CartDaoImpl implements CartDao{
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean addProductCart(int productId,int productQuantity) {
		try {
			ProductBean productBean = new ProductBean();
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			CartBean cartBean = new CartBean();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("from ProductBean where productId=:pId");
			query.setParameter("pId", productId);
			productBean = (ProductBean) query.getSingleResult();
			cartBean.setProductId(productId);
			cartBean.setProductName(productBean.getProductName());
			cartBean.setProductPrice(productBean.getProductPrice());
			cartBean.setProductQuantity(productQuantity);
			entityManager.persist(cartBean);
			transaction.commit();
			entityManager.close();
			return true;
		}catch(Exception e) {
		//	e.printStackTrace();
			System.out.println("This Product already exist in your cart.");
			System.out.println("Please Update your Cart");
			return false;
		}//End of addProductCart	
	}//End of addProductCart()

	@Override
	public boolean deleteProductCart(int productId) {
	try {
		entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("delete from CartBean where productId=:pid");
		query.setParameter("pid", productId);
		int rs = query.executeUpdate();
		if(rs>0) {
			System.out.println("ProductId Deleted Successfully");
			transaction.commit();
			entityManager.close();
			return true;
		}else {
			System.out.println("Invalid Credential");
			return false;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}//End of catch()
		return false;
	}//End of deleteProductCart()

	@Override
	public boolean updateProductCart(int productQuantity, int productId) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			Query query = entityManager.createQuery("update CartBean set productQuantity=:pquantity where productId=:pid");
			query.setParameter("pquantity", productQuantity);
			query.setParameter("pid", productId);
			int rs = query.executeUpdate();
			if(rs>0) {
				System.out.println("Product Updated Successfully");
				Query query1 = entityManager.createQuery("from CartBean where productId=:pid");
				query1.setParameter("pid", productId);
				List<CartBean> cartBean = query1.getResultList();
				for(CartBean cart : cartBean) {
					System.out.println("******************************");
					System.out.println("The ProductId: " + cart.getProductId());
					System.out.println("The ProductName: " + cart.getProductName());
					System.out.println("The ProductPrice: " + cart.getProductPrice());
					System.out.println("The ProductQuantity: " + cart.getProductQuantity());
					System.out.println();
				}//End of for each
				transaction.commit();
				entityManager.close();
				return true;
			}else {
				System.out.println("Invalid Credentials");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch
		return false;
	}//End of updateProductCart()

	@Override
	public long addBill() {
		long bill = 0;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			//ProductBean productBean = new ProductBean();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("Select sum(productPrice*productQuantity) from CartBean");
			bill = (long) query.getSingleResult();
			transaction.commit();
			entityManager.close();
			return bill;
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch()
		return bill;
	}//End of addBill()

	@Override
	public boolean AllProductCart() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("from CartBean");
			if(query.getResultList().isEmpty()) {
				System.out.println("The Cart is Empty");
				return false;
			}else {
			List<CartBean> cart = query.getResultList();
			System.out.println("The List of all Product-");
			for(CartBean cartBean : cart) {
				System.out.println("**************************");
				System.out.println("The ProductId: " + cartBean.getProductId());
				System.out.println("The ProductName: " + cartBean.getProductName());
				System.out.println("The ProductPrice: " + cartBean.getProductPrice());
				System.out.println("The Product Quantity: " + cartBean.getProductQuantity());
				System.out.println("**************************");
				System.out.println();
				
			}//End of for each()
			return true;
			}//End of else
			
		}catch(Exception e) {
			e.printStackTrace();
		}//End of catch
		return true;
	}//End of AllProductCart

	@Override
	public boolean deleteAllCart() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("DELETE from CartBean");
			int rs = query.executeUpdate();
			if(rs>0) {
				transaction.commit();
				entityManager.close();
				return true;
			}else {
				System.out.println("Sommething went wrong");
				return false;
			}//End of false
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()	
	}//End of deleteAllCart()
	
	
}//End of CartDaoImpl
