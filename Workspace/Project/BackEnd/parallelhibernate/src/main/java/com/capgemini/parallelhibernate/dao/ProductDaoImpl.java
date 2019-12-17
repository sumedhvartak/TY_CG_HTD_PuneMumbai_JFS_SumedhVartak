package com.capgemini.parallelhibernate.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.parallelhibernate.beans.ProductBean;

public class ProductDaoImpl implements ProductDao{
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean addProduct(ProductBean productBean) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(productBean);
			System.out.println("Product Added Successfully");
			System.out.println();
			System.out.println("Added Product is");
			System.out.println("**************************");
			System.out.println("The ProductId: " + productBean.getProductId());
			System.out.println("The ProductName: " + productBean.getProductName());
			System.out.println("The ProductPrice: " + productBean.getProductPrice());
			System.out.println("The ProductType: " + productBean.getProductType());
			System.out.println("The Product Status: " + productBean.getStatus());
			System.out.println("The Product Quantity: " + productBean.getQuantity());
			System.out.println("**************************");
			System.out.println();
			transaction.commit();
			entityManager.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch
	}//End of addProduct

	@Override
	public boolean deleteProduct(int productId) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("Delete from ProductBean where productId=:pi");
			query.setParameter("pi", productId);
			int rs = query.executeUpdate();
			System.out.println("Product Deleted Successfully"); 
			transaction.commit();
			entityManager.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()
	}//End of deleteProduct

	@Override
	public boolean updateProduct(int productId, int price, int productQuantity, String productStatus) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("Update ProductBean set productPrice=:pprice, quantity=:pquantity, status=:pstatus where productId=:pid");
			query.setParameter("pprice", price);
			query.setParameter("pquantity", productQuantity);
			query.setParameter("pid", productId);
			query.setParameter("pstatus", productStatus);
			int rs = query.executeUpdate();
			if(rs > 0 ) {
				System.out.println("Product Updated Successfully");
				Query query1 = entityManager.createQuery("from ProductBean where productId=:pid");
				query1.setParameter("pid", productId);
				List<ProductBean> product = query1.getResultList();
				for(ProductBean res : product) {
					System.out.println("The Updated Product:    ");
					System.out.println("**************************************");
					System.out.println("The ProductId: " + res.getProductId());
					System.out.println("The ProductName: " + res.getProductName());
					System.out.println("The ProductPrice: " + res.getProductPrice());
					System.out.println("The ProductType: " + res.getProductType());
					System.out.println("The ProductStatus: " + res.getStatus());
					System.out.println("The ProductQuantity: " + res.getQuantity());
					System.out.println();
				}//End of for each
				
				transaction.commit();
				entityManager.close();
				return true;
			}else {
				System.out.println("You have Invalid Credentials");
				return false;
			}//End of else
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}//End of catch()
	}//End of updateProduct()

	@Override
	public void AllProduct() {
		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("onlineMedicalApp");
		entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("from ProductBean");
		List<ProductBean> product = query.getResultList();
		System.out.println("The List of all Product-");
		for(ProductBean productBean : product) {
			System.out.println("**************************");
			System.out.println("The ProductId: " + productBean.getProductId());
			System.out.println("The ProductName: " + productBean.getProductName());
			System.out.println("The ProductPrice: " + productBean.getProductPrice());
			System.out.println("The ProductType: " + productBean.getProductType());
			System.out.println("The Product Status: " + productBean.getStatus());
			System.out.println("The Product Quantity: " + productBean.getQuantity());
			System.out.println("**************************");
			System.out.println();
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Retrieve All Data");
		}
	}//End of AllProduct()	
}//End of ProductDao
