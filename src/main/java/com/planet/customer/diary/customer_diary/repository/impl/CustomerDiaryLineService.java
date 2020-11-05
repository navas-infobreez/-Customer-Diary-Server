package com.planet.customer.diary.customer_diary.repository.impl;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.CustomerDiaryLine;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryLineDTO;

public interface CustomerDiaryLineService {

	public List<CustomerDiaryLineDTO> findByCustomerDiaryId(Long id);
	
	public List<CustomerDiaryLine> mapCustomerDiaryLineDTOToEntity(final List<CustomerDiaryLineDTO> CustomerDiaryLineList,
																						final CustomerDiary customerDiary);	
	
	public List<CustomerDiaryLineDTO> findByProductId(Long productId);
	
	public List<CustomerDiaryLineDTO> findByProductCategoryId(Long productCategoryId);

	public List<CustomerDiaryLineDTO> mapCustomerDiaryLineEntityToDTO(
			final List<CustomerDiaryLine> customerDiaryLineList);
}