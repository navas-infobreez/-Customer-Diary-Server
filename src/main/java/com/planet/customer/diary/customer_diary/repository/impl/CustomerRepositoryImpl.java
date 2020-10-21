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
		final String hql = "from Customer where lower(search_key) = :searchkey";
		List<Customer> customerList = getSession().createQuery(hql).setParameter("searchkey", searchKey.toLowerCase())
				.list();
		return customerList.size() == 1 ? customerList.get(0) : null;
	}


}
