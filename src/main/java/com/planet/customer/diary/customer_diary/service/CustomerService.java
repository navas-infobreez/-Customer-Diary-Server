package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.model.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO createOrUpdateCustomer(CustomerDTO customer);

	List<CustomerDTO> findAll();
	
	CustomerDTO findBySearchKey(String customerSearchKey);
	
	CustomerDTO findByCustomerId(Long id);

	void delete(Long id);

}