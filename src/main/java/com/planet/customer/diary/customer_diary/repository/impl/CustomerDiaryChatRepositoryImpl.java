package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.CustomerDiaryChat;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryChatRepository;

@Repository
public class CustomerDiaryChatRepositoryImpl implements CustomerDiaryChatRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<CustomerDiaryChat> findByCustomerDiaryId(Long customerDiaryId) {
		final String hql = "FROM CustomerDiaryChat where customerdiary_id = :customerDiaryId";
		List<CustomerDiaryChat> customerDiaryChatList = getSession().createQuery(hql)
				.setParameter("customerDiaryId", customerDiaryId).list();
		return customerDiaryChatList;
	}

	@Override
	public List<CustomerDiaryChat> findByCustomerDiaryIds(List<Long> customerDiaryIds) {
		final String hql = "FROM CustomerDiaryChat WHERE customerdiary_id in = :customerDiaryId";
		List<CustomerDiaryChat> customerDiaryChatList = getSession().createQuery(hql)
				.setParameterList("customerDiaryId", customerDiaryIds).list();
		return customerDiaryChatList;
	}


}
