package com.planet.customer.diary.customer_diary.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerVisit;

public interface CustomerVisitRepository {
	
	public List<CustomerVisit> findByCustomerDiaryId(Long customerDiaryId);
	
	public List<CustomerVisit> findByCustomerId(Long customerId);
	
	public List<CustomerVisit> findByDate(Date date);
	
	public List<CustomerVisit> findByTime(Timestamp time);

}