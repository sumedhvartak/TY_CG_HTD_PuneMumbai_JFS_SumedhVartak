package com.capgemini.parallelrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.parallelrest.beans.ProductBean;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addProduct(ProductBean productBean) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(productBean);// Inserting product
			transaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} // End of catch()

	}// End of addProduct

	@Override
	public List<ProductBean> showAllProduct() {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			Query query = entityManager.createQuery("from ProductBean");
			List<ProductBean> list = query.getResultList();
			entityManager.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} // End of catch()
	}// End of showAllProduct

	@Override
	public boolean deleteProduct(int productId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("delete from ProductBean where productId=:product");
			query.setParameter("product", productId);
			int rs = query.executeUpdate();
			if (rs > 0) {
				transaction.commit();
				entityManager.close();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Failed to delete.product may be present in cart");
			return false;
		} // End of catch
	}// End of deleteProduct()

	@Override
	public boolean updateProduct(int productId, int productPrice, int quantity) {
		try {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("update ProductBean set productPrice=:price, quantity=:quan where productId=:productid ");
		query.setParameter("price", productPrice);
		query.setParameter("quan", quantity);
		query.setParameter("productid", productId);
		query.executeUpdate();
//		ProductBean update = entityManager.find(ProductBean.class, productBean.getProductId());
//
//		if (update != null) {
//			int productPrice = productBean.getProductPrice();
//			if (productPrice > 0) {
//				update.setProductPrice(productPrice);
//			}
//
//			int productQuantity = productBean.getQuantity();
//			if (productQuantity > 0) {
//				update.setQuantity(productQuantity);
//			}
//
//			String productStatus = productBean.getStatus();
//			if (productStatus != null) {
//				update.setStatus(productStatus);
//			}
//		}
			transaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Update Product");
			return false;
		}//End of catch()
	}// End of updateProduct

}// End of ProductDaoImpl
