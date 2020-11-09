package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryChatDTO;

public interface CustomerDiaryChatService {

	public List<CustomerDiaryChatDTO> findByCustomerDiaryId(Long diaryId);

	public List<CustomerDiaryChatDTO> createOrUpdateCustomerDiaryChat(List<CustomerDiaryChatDTO> customerDiaryChatList);
	
	public List<CustomerDiaryChatDTO> findByCustomerDiaryList(List<Long> diaryIds);

}