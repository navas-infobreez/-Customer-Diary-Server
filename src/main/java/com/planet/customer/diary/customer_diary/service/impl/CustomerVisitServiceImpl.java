package com.planet.customer.diary.customer_diary.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.Customer;
import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.CustomerVisit;
import com.planet.customer.diary.customer_diary.model.dto.CustomerVisitDTO;
import com.planet.customer.diary.customer_diary.repository.CustomerVisitRepository;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.CustomerVisitService;

@Service(value = "customerVisitService")
public class CustomerVisitServiceImpl extends BasicServiceImpl implements CustomerVisitService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Autowired
	private CustomerVisitRepository customerVisitRepository;

	@Override
	public CustomerVisit mapDTOToCustomerVisitEntity(final CustomerVisitDTO customerVisitDTO) {
		CustomerVisit customerVisit = null;	
		if (!customerVisitDTO.isEmpty()) {
			customerVisit = findById(customerVisitDTO.getId());
			customerVisit.setDate(customerVisitDTO.getDate());
			customerVisit.setTime(customerVisitDTO.getTime());
			customerVisit.setPlace(customerVisitDTO.getPlace());
			CustomerDiary customerDiary = genericRepository.findById(CustomerDiary.class,
					customerVisitDTO.getCustomerDiaryId());
			if (customerDiary == null)
				throw new EntityNotFoundException("CustomerDiary not found");
			customerVisit.setCustomerDiary(customerDiary);
			Customer customer = genericRepository.findById(Customer.class, customerVisitDTO.getCustomerId());
			if (customer == null)
				throw new EntityNotFoundException("Customer not found");
			customerVisit.setCustomer(customer);
		}else {
			customerVisit = new CustomerVisit();
			customerVisit = (CustomerVisit) mapDTOToEntity(customerVisitDTO, customerVisit);
		}	
		return customerVisit;
	}

	private CustomerVisit findById(final Long id) {
		return genericRepository.findById(CustomerVisit.class, id);
	}
	
	private CustomerVisitDTO mapCustomerVisitEntityToDTO(final CustomerVisit customerVisit) {
		CustomerVisitDTO tempCustomerVisitDTO = mapEntityToDTO(customerVisit, CustomerVisitDTO.class);
		tempCustomerVisitDTO.setCustomerDiaryId(customerVisit.getCustomerDiary().getId());
		tempCustomerVisitDTO.setCustomerId(customerVisit.getCustomer().getId());
		return tempCustomerVisitDTO;
	}

	private List<CustomerVisitDTO> mapCustomerVisitLineEntityToDTO(final List<CustomerVisit> customerVisitList) {
		List<CustomerVisitDTO> tempDTOs = null;
		if (!customerVisitList.isEmpty()) {
			tempDTOs = customerVisitList.stream().map(this::mapCustomerVisitEntityToDTO).collect(Collectors.toList());
		}
		return tempDTOs;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerVisit> findAll() {
		return genericRepository.findAll(CustomerVisit.class);
	}

	@Override
	@Transactional
	public CustomerVisitDTO createOrUpdateCustomerVisit(final CustomerVisitDTO customerVisitDTO) {
		if(customerVisitDTO == null)
			return null;
		CustomerVisit customerVisit = mapDTOToCustomerVisitEntity(customerVisitDTO);
		Long id = customerVisitDTO.getId();		
		if (!customerVisitDTO.isEmpty()) {
			genericRepository.saveOrUpdate(customerVisit);
		}else {			
			id = (Long) genericRepository.save(customerVisit);
		}
		return mapCustomerVisitEntityToDTO(findById(id));
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerVisitDTO findByCustomerVisitId(Long customerVisitId) {
		final CustomerVisit customerVisit =  findById(customerVisitId);
		if (customerVisit == null) {
			return null;
		}
		return mapCustomerVisitEntityToDTO(customerVisit);
	}

	@Override
	@Transactional
	public void delete(Long CustomerVisitid) {
		final CustomerVisit customerVisit = findById(CustomerVisitid);
		if (customerVisit != null) {
			genericRepository.delete(customerVisit);
		}
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<CustomerVisitDTO> findByCustomerId(Long customerId) {
		final List<CustomerVisit> customerVisitLineList = customerVisitRepository.findByCustomerId(customerId);
		return mapCustomerVisitLineEntityToDTO(customerVisitLineList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerVisitDTO> findByDate(Date date) {
		final List<CustomerVisit> customerVisitLineList = customerVisitRepository.findByDate(date);
		return mapCustomerVisitLineEntityToDTO(customerVisitLineList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerVisitDTO> findByTime(Timestamp time) {
		final List<CustomerVisit> customerVisitLineList = customerVisitRepository.findByTime(time);
		return mapCustomerVisitLineEntityToDTO(customerVisitLineList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerVisitDTO> findByCustomerDiaryId(Long customerDiaryId) {
		final List<CustomerVisit> customerVisitLineList = customerVisitRepository.findByCustomerDiaryId(customerDiaryId);
		return mapCustomerVisitLineEntityToDTO(customerVisitLineList);
	}
	
	
}