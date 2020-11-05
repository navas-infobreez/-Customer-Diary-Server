package com.planet.customer.diary.customer_diary.repository;


import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;

public interface CustomerDiaryRepository {

	public List<CustomerDiary> getAllActiveCustomerDiary();

	public List<CustomerDiary> findBySalesRepId(Long salesrepId);
	
	public List<CustomerDiary> findByCustomerId(Long customerId);
	
	public List<CustomerDiary> findByDocumentNo(String documentno);

	public List<CustomerDiary> findByInvoiceNo(String invoiceno);

	public long getNextDocumentNo();

}
