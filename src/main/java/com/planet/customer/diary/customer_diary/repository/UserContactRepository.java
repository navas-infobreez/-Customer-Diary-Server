package com.planet.customer.diary.customer_diary.repository;

import com.planet.customer.diary.customer_diary.entity.UserContact;

public interface UserContactRepository {
	
	UserContact findByUserId(Long userId);

}