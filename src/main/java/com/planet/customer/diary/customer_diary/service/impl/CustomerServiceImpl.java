package com.planet.customer.diary.customer_diary.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.Customer;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDTO;
import com.planet.customer.diary.customer_diary.repository.CustomerRepository;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.CustomerContactService;
import com.planet.customer.diary.customer_diary.service.CustomerService;
import com.planet.customer.diary.customer_diary.service.UserContactService;

@Service(value = "customerService")
public class CustomerServiceImpl extends BasicServiceImpl implements CustomerService{

	@Autowired
	@Qualifier("genericRepository")
	private GenericRepository genericRepository;
	
	@Autowired
	private CustomerContactService customerContactService;
	
	@Autowired
	@Qualifier("customerRepository")
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private List<CustomerDTO> mapCustomerEntitiesToDTOs(final List<Customer> customer) {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		if (!customer.isEmpty()) {
			customerDTOs = customer.stream().map(this::mapCustomerEntityToDTO).collect(Collectors.toList());
		}
		return customerDTOs;
	}
	
	
	private CustomerDTO mapCustomerEntityToDTO(final Customer customer) {
		CustomerDTO tempCustomerDTO = new CustomerDTO();
		if (customer != null) {
			tempCustomerDTO = modelMapper.map(customer, tempCustomerDTO.getClass());
		}
		return tempCustomerDTO;
	}

	
	private Customer mapDTOToCustomerEntity(final CustomerDTO customerDTO) {
		Customer customer = null;	
		if(customerDTO.getId() != null && customerDTO.getId() > 0) {
			customer = findById(customerDTO.getId());
			customer.setSearchKey(customerDTO.getSearchKey());
			customer.setFirstName(customerDTO.getFirstName());
			customer.setLastName(customerDTO.getLastName());
		}else {
			customer = new Customer();
			customer = (Customer) mapDTOToEntity(customerDTO, customer);
		}	
		customer.setCustomerContact(customerContactService.mapCustomerContactDTOToEntity(customerDTO.getCustomerContact(),customer));
		return customer;
	}


	private Customer findById(final Long id) {
		return genericRepository.findById(Customer.class, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerDTO> findAll() {
		final List<Customer> customer = genericRepository.findAll(Customer.class);
		return mapCustomerEntitiesToDTOs(customer);
	}
	
	
	@Override
	@Transactional
	public CustomerDTO createOrUpdateCustomer(CustomerDTO customerDTO) {
		if(customerDTO == null)
			throw new NullPointerException("No data found customer information");
		if(customerDTO.getId() != null && customerDTO.getId() > 0) {
			genericRepository.saveOrUpdate(mapDTOToCustomerEntity(customerDTO));
		}else {
			final Serializable userId = genericRepository.save(mapDTOToCustomerEntity(customerDTO));
			customerDTO.setId((Long) userId);
		}
		return mapCustomerEntityToDTO(findById(customerDTO.getId()));
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerDTO findByCustomerId(Long id) {
		final Customer customer =  findById(id);
		if (customer == null) {
			return null;
		}
		return mapCustomerEntityToDTO(customer);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		final Customer customer = findById(id);
		if (customer != null) {
			genericRepository.delete(customer);
		}
	}


	@Override
	@Transactional(readOnly = true)
	public CustomerDTO findBySearchKey(String customerSearchKey) {
		final Customer customer = customerRepository.findBySearchKey(customerSearchKey);
		if (customer == null) {
			return null;
		}
		return mapCustomerEntityToDTO(customer);
	}
}
