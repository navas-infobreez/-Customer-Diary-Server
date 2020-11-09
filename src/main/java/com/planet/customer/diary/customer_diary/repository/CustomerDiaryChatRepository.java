package com.planet.customer.diary.customer_diary.repository;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.CustomerDiaryChat;

public interface CustomerDiaryChatRepository {
	
	public List<CustomerDiaryChat> findByCustomerDiaryId(Long customerDiaryId);
	
	public List<CustomerDiaryChat> findByCustomerDiaryIds(List<Long> customerDiaryIds);
	
}