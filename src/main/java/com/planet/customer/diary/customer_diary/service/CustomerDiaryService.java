package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryDTO;

public interface CustomerDiaryService {

	CustomerDiaryDTO createOrUpdateCustomerDiary(CustomerDiaryDTO customerDiaryDTO);

	List<CustomerDiaryDTO> findAll();

	List<CustomerDiaryDTO> getAllActiveCustomerDiary();

	CustomerDiaryDTO findByCustomerDiaryId(Long id);

	void delete(Long id);
	
	List<CustomerDiaryDTO> findBySalesRepId(Long salesrepId);

	List<CustomerDiaryDTO> findByCustomerId(Long customerId);
	
	List<CustomerDiaryDTO> findByDocumentNo(String documentno);

	List<CustomerDiaryDTO> findByInvoiceNo(String invoiceno);
	
	CustomerDiary mapDTOToCustomerDiaryEntity(CustomerDiaryDTO customerDiaryDTO);
}