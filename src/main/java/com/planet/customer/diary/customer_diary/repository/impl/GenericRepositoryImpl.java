package com.planet.customer.diary.customer_diary.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.BaseEntity;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;

/**
 *
 * @author Arun Kumar S A
 *
 * @param <T>
 */
@Repository("genericRepository")
public class GenericRepositoryImpl implements GenericRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public <E extends BaseEntity> E get(final Class<E> type, final Long id) {
		return getSession().get(type, id);
	}

	@Override
	public <E extends BaseEntity> Serializable save(final E entity) {
		return getSession().save(entity);
	}

	@Override
	public <E extends BaseEntity> void saveOrUpdate(final E entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public <E extends BaseEntity> void delete(final E entity) {
		getSession().delete(entity);
	}

	@Override
	public <E extends BaseEntity> void deleteAll(final Class<E> entityClass) {
		final List<? extends BaseEntity> entities = findAll(entityClass);
		if (!entities.isEmpty()) {
			for (final BaseEntity entityToDelete : entities) {
				getSession().delete(entityToDelete);
			}
		}
	}

	@Override
	public <E extends BaseEntity> List<E> findAll(final Class<E> entityClass) {
		return getSession().createQuery("from " + entityClass.getName(), entityClass).list();
	}

	@Override
	public void clear() {
		getSession().clear();
	}

	@Override
	public void flush() {
		getSession().flush();
	}

	@Override
	public <E extends BaseEntity> E findById(final Class<E> baseEntityClass, final Long id) {
		return getSession().get(baseEntityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends BaseEntity> E merge(final E entity) {
		return (E) getSession().merge(entity);
	}

}