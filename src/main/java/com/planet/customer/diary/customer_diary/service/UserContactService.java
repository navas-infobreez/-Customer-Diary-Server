package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import javax.validation.Valid;

import  com.planet.customer.diary.customer_diary.entity.UserContact;

public interface UserContactService {

	public List<UserContact> findAll();

	public UserContact save(@Valid UserContact userContact);

}