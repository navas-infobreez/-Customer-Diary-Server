package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.Customer;
import com.planet.customer.diary.customer_diary.entity.CustomerContact;
import com.planet.customer.diary.customer_diary.model.dto.CustomerContactDTO;

public interface CustomerContactService {

	public List<CustomerContact> findAll();

	public CustomerContact createOrUpdateCustomerContact(CustomerContactDTO customerContactDTO,Customer customer);
	
	public CustomerContact mapCustomerContactDTOToEntity(CustomerContactDTO customerContactDTO,Customer customer);
}