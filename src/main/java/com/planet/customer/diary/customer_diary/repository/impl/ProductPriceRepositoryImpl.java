package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.ProductPrice;
import com.planet.customer.diary.customer_diary.repository.ProductPriceRepository;

@Repository("productPriceRepository")
public class ProductPriceRepositoryImpl implements ProductPriceRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}


	@Override
	public List<ProductPrice> findByProductId(Long productId) {
		final String hql = "from ProductPrice where product_id = :productId";
		List<ProductPrice> productPrice = getSession().createQuery(hql).setParameter("productId", productId).list();
		return productPrice;
	}

}
