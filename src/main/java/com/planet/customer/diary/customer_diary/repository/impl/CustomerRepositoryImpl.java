package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.Customer;
import com.planet.customer.diary.customer_diary.repository.CustomerRepository;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Customer findBySearchKey(String searchKey) {
		final String hql = "from Customer where lower(searchkey) = :searchkey";
		List list = getSession().createQuery(hql).setParameter("searchkey", searchKey.toLowerCase()).list();
		
		return list.size() == 1 ? (Customer)list.get(0): null;
	}


}
