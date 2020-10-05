package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.entity.UserRoleMap;
import com.planet.customer.diary.customer_diary.repository.UserRoleMapRepository;

@Repository("userRoleMapRepository")
public class UserRoleMapRepositoryImpl implements UserRoleMapRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<UserRoleMap> findByUserId(Long id) {
		final String hql = "from UserRoleMap where user_id = :user_id";
		List<UserRoleMap> userRoleList = getSession().createQuery(hql).setParameter("user_id", id).list();		
		return userRoleList;
	}

	@Override
	public UserRoleMap findUserRoleMapbyRoleId(Long userId, Long roleId) {
		final String hql = "from UserRoleMap where user_id = :user_id AND user_role_id=:user_role_id";
		List<UserRoleMap> userRoleList = getSession().createQuery(hql).setParameter("user_id", userId).setParameter("user_role_id", roleId).list();		
		return userRoleList.size() == 1 ? userRoleList.get(0): null;
	}

}
