package com.planet.customer.diary.customer_diary.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerVisit;
import com.planet.customer.diary.customer_diary.model.dto.CustomerVisitDTO;

public interface CustomerVisitService {

	public List<CustomerVisit> findAll();

	public CustomerVisitDTO createOrUpdateCustomerVisit(CustomerVisitDTO customerVisitDTO);

	CustomerVisitDTO findByCustomerVisitId(Long customerVisitId);

	void delete(Long customerVisitid);

	public CustomerVisit mapDTOToCustomerVisitEntity(final CustomerVisitDTO customerVisitDTO);
	
	public List<CustomerVisitDTO> findByCustomerDiaryId(Long customerDiaryId);
	
	public List<CustomerVisitDTO> findByCustomerId(Long customerId);
	
	public List<CustomerVisitDTO> findByDate(Date date);
	
	public List<CustomerVisitDTO> findByTime(Timestamp time);
}