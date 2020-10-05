package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.UserContact;
import com.planet.customer.diary.customer_diary.repository.UserContactRepository;

@Repository
public class UserContactRepositoryImpl implements UserContactRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public UserContact findByUserId(Long userId) {
		final String hql = "from UserContact where user_id = :user_id";
		List<UserContact> userContactList = getSession().createQuery(hql).setParameter("user_id", userId).list();		
		return userContactList.size() == 1 ? userContactList.get(0): null;
	}

}
