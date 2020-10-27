package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.CustomerDiaryLine;
import com.planet.customer.diary.customer_diary.entity.ProductPrice;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryLineRepository;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryRepository;
import com.planet.customer.diary.customer_diary.repository.ProductPriceRepository;

@Repository("customerDiaryLineRepository")
public class CustomerDiaryLineRepositoryImpl implements CustomerDiaryLineRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}


	@Override
	public List<CustomerDiaryLine> findByCustomerDiaryId(Long customerDiaryId) {
		final String hql = "from CustomerDiaryLine where customer_diary_id = :customerDiaryId";
		List<CustomerDiaryLine> productPrice = getSession().createQuery(hql).setParameter("customerDiaryId", customerDiaryId).list();
		return productPrice;
	}


	@Override
	public List<CustomerDiaryLine> findByProductId(Long productId) {
		final String hql = "from CustomerDiaryLine where product_id = :productId";
		List<CustomerDiaryLine> productPrice = getSession().createQuery(hql).setParameter("productId", productId).list();
		return productPrice;
	}


	@Override
	public List<CustomerDiaryLine> findByProductCategoryId(Long productCategoryId) {
		final String hql = "from CustomerDiaryLine where product_category_id = :productCategoryId";
		List<CustomerDiaryLine> productPrice = getSession().createQuery(hql).setParameter("productCategoryId", productCategoryId).list();
		return productPrice;
	}



}
