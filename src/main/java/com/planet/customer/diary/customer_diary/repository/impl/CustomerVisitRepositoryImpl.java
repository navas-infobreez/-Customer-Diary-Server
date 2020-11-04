package com.planet.customer.diary.customer_diary.repository.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.CustomerVisit;
import com.planet.customer.diary.customer_diary.repository.CustomerVisitRepository;

@Repository
public class CustomerVisitRepositoryImpl implements CustomerVisitRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<CustomerVisit> findByCustomerDiaryId(Long customerDiaryId) {
		final String hql = "from CustomerVisit where customerdiary_id = :customerDiaryId";
		List<CustomerVisit> customerVisit = getSession().createQuery(hql).setParameter("customerDiaryId", customerDiaryId).list();		
		return customerVisit;
	}
	@Override
	public List<CustomerVisit> findByCustomerId(Long customerId) {
		final String hql = "from CustomerVisit where customer_id = :customerId";
		List<CustomerVisit> customerVisit = getSession().createQuery(hql).setParameter("customerId", customerId).list();		
		return customerVisit;
	}

	@Override
	public List<CustomerVisit> findByDate(Date date) {
		final String hql = "from CustomerVisit where date = :date";
		List<CustomerVisit> customerVisit = getSession().createQuery(hql).setParameter("date", date).list();		
		return customerVisit;
	}

	@Override
	public List<CustomerVisit> findByTime(Timestamp time) {
		final String hql = "from CustomerVisit where time = :time";
		List<CustomerVisit> customerVisit = getSession().createQuery(hql).setParameter("time", time).list();		
		return customerVisit;
	}

}
