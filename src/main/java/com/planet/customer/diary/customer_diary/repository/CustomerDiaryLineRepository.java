package com.planet.customer.diary.customer_diary.repository;


import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerDiaryLine;

public interface CustomerDiaryLineRepository {

	public List<CustomerDiaryLine> findByCustomerDiaryId(Long customerDiaryId);
	
	public List<CustomerDiaryLine> findByProductId(Long productId);
	
	public List<CustomerDiaryLine> findByProductCategoryId(Long productCategoryId);

}
