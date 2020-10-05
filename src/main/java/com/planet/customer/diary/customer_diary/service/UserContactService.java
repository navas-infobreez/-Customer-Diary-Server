package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.User;
import  com.planet.customer.diary.customer_diary.entity.UserContact;
import com.planet.customer.diary.customer_diary.model.dto.UserContactDTO;

public interface UserContactService {

	public List<UserContact> findAll();

	public UserContact createOrUpdateUserContact(UserContactDTO userContactDTO,User user);
	
	public UserContact mapUserContactDTOToEntity(UserContactDTO userContactDTO,User user);
}