package com.planet.customer.diary.customer_diary.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planet.customer.diary.customer_diary.entity.UserContact;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.UserContactService;

@Service
public class UserContactServiceImpl implements UserContactService {

	@Autowired
	private GenericRepository genericRepository;

	@Override
	public List<UserContact> findAll() {
		return genericRepository.findAll(UserContact.class);
	}

	@Override
	public UserContact save(@Valid final UserContact userContact) {
		@Valid
		final Serializable savedEntityId = genericRepository.save(userContact);
		userContact.setId((Long) savedEntityId);
		return userContact;
	}

}