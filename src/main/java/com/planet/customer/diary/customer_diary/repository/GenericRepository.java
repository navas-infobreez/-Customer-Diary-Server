package com.planet.customer.diary.customer_diary.repository;

import java.io.Serializable;
import java.util.List;

import com.planet.customer.diary.customer_diary.entity.BaseEntity;

/**
 * Interface to provide common DAO methods
 *
 */
public interface GenericRepository {

	/**
	 *
	 * @param entity: entity to save
	 * @return Identifier of saved entity
	 */
	<E extends BaseEntity> Serializable save(final E entity);

	/**
	 *
	 * @param <E>
	 * @param entity
	 */
	<E extends BaseEntity> void saveOrUpdate(final E entity);

	/**
	 *
	 * @param entity: entity to delete
	 */
	<E extends BaseEntity> void delete(E entity);

	/**
	 * Delete all records
	 */
	<E extends BaseEntity> void deleteAll(final Class<E> entityClass);

	/**
	 * Find all records
	 *
	 * @return
	 */
	<E extends BaseEntity> List<E> findAll(final Class<E> entityClass);

	/**
	 * Find by primary key
	 *
	 * @param baseEntityClass
	 * @param id
	 * @return
	 */
	<E extends BaseEntity> E findById(final Class<E> baseEntityClass, final Long id);

	/**
	 * Clear session
	 */
	void clear();

	/**
	 * Flush session
	 */
	void flush();

	/**
	 *
	 * @param <E>
	 * @param type
	 * @param id
	 * @return
	 */
	<E extends BaseEntity> E get(final Class<E> type, final Long id);

	/**
	 *
	 * @param <E>
	 * @param entity
	 * @return
	 */
	<E extends BaseEntity> E merge(E entity);

}
