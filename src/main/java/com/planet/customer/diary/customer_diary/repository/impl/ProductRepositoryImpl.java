package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.repository.ProductRepository;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Product> getAllActiveProduct() {
		final String hql = "from Product where active = :active";
		List<Product> productList = getSession().createQuery(hql).setParameter("active", true).list();
		return productList;
	}

	@Override
	public List<Product> findByProductCategoryId(Long categoryId) {
		final String hql = "from Product where product_category_id = :categoryId";
		List<Product> productList = getSession().createQuery(hql).setParameter("categoryId", categoryId).list();
		return productList;
	}

}
