package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public User findByUserName(final String username) {
		final String hql = "from User where lower(userName) = :username";
		List list = getSession().createQuery(hql).setParameter("username", username.toLowerCase()).list();
		
		return list.size() == 1 ? (User)list.get(0): null;
	}

}
