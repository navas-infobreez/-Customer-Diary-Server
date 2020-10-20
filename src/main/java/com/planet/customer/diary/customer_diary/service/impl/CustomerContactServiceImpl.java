package com.planet.customer.diary.customer_diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.Customer;
import com.planet.customer.diary.customer_diary.entity.CustomerContact;
import com.planet.customer.diary.customer_diary.model.dto.CustomerContactDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.CustomerContactService;

@Service
public class CustomerContactServiceImpl extends BasicServiceImpl implements CustomerContactService {

	@Autowired
	private GenericRepository genericRepository;
	
	
	
	@Override
	public List<CustomerContact> findAll() {
		return genericRepository.findAll(CustomerContact.class);
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerContact createOrUpdateCustomerContact(final CustomerContactDTO customerContactDTO,Customer customer) {		
		if(customerContactDTO == null)
			return null;
		CustomerContact customerContact = mapCustomerContactDTOToEntity(customerContactDTO,customer);
		Long id = customerContactDTO.getId();		
		if(id != null && id > 0) {
			genericRepository.saveOrUpdate(customerContact);
		}else {			
			id = (Long) genericRepository.save(customerContact);
		}
		customerContact = genericRepository.findById(CustomerContact.class, id);
		return customerContact;
	}
	
	
	public CustomerContact mapCustomerContactDTOToEntity(CustomerContactDTO customerContactDTO,Customer customer){
		CustomerContact customerContact = null;
		if(customer.getCustomerContact() != null) {
			customerContact = customer.getCustomerContact();
			customerContact.setEmail(customerContactDTO.getEmail());
			customerContact.setCountry(customerContactDTO.getCountry());
			customerContact.setCity(customerContactDTO.getCity());
			customerContact.setCountry(customerContactDTO.getCountry());
			customerContact.setState(customerContactDTO.getState());
			customerContact.setLandmark(customerContactDTO.getLandmark());
			customerContact.setPinNo(customerContactDTO.getPinNo());
			customerContact.setAddress1(customerContactDTO.getAddress1());
			customerContact.setAddress2(customerContactDTO.getAddress2());
			customerContact.setContactNo(customerContactDTO.getContactNo());
			customerContact.setContactNo2(customerContactDTO.getContactNo2());
		}
		else {
			customerContact = new CustomerContact();
			customerContact = (CustomerContact) super.mapDTOToEntity(customerContactDTO, customerContact);
		}
		customerContact.setCustomer(customer);
		return customerContact;
	}
	
}