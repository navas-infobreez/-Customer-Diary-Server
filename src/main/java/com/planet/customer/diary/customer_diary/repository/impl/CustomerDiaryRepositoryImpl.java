package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryRepository;

@Repository("customerDiaryRepository")
public class CustomerDiaryRepositoryImpl implements CustomerDiaryRepository {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<CustomerDiary> getAllActiveCustomerDiary() {
		final String hql = "from CustomerDiary where active = :active";
		List<CustomerDiary> customerDiaryList = getSession().createQuery(hql).setParameter("active", true).list();
		return customerDiaryList;
	}

	@Override
	public List<CustomerDiary> findBySalesRepId(Long salesrepid) {
		final String hql = "from CustomerDiary where salesrep_id = :salesrepid";
		List<CustomerDiary> customerDiaryList = getSession().createQuery(hql).setParameter("salesrepid", salesrepid).list();
		return customerDiaryList;
	}

	@Override
	public List<CustomerDiary> findByCustomerId(Long customerid) {
		final String hql = "from CustomerDiary where customer_id = :customerid";
		List<CustomerDiary> customerDiaryList = getSession().createQuery(hql).setParameter("customerid", customerid).list();
		return customerDiaryList;
	}

	@Override
	public List<CustomerDiary> findByDocumentNo(String documentno) {
		final String hql = "from CustomerDiary where lower(document_no) = :documentno";
		List<CustomerDiary> customerDiaryList = getSession().createQuery(hql).setParameter("documentno", documentno).list();
		return customerDiaryList;
	}

	@Override
	public List<CustomerDiary> findByInvoiceNo(String invoiceno) {
		final String hql = "from CustomerDiary where lower(invoice_no) = :invoiceno";
		List<CustomerDiary> customerDiaryList = getSession().createQuery(hql).setParameter("invoiceno", invoiceno).list();
		return customerDiaryList;
	}

}
