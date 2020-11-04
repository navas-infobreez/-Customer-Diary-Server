package com.planet.customer.diary.customer_diary.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.CustomerVisit;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDTO;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryDTO;
import com.planet.customer.diary.customer_diary.model.dto.CustomerVisitDTO;
import com.planet.customer.diary.customer_diary.repository.CustomerVisitRepository;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryService;
import com.planet.customer.diary.customer_diary.service.CustomerService;
import com.planet.customer.diary.customer_diary.service.CustomerVisitService;

@Service(value = "customerVisitService")
public class CustomerVisitServiceImpl extends BasicServiceImpl implements CustomerVisitService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Autowired
	private CustomerVisitRepository customerVisitRepository;
	
	@Autowired
	private CustomerDiaryService customerDairyService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CustomerVisit mapDTOToCustomerVisitEntity(final CustomerVisitDTO customerVisitDTO) {
		CustomerVisit customerVisit = null;	
		if(customerVisitDTO.getId() != null && customerVisitDTO.getId() > 0) {
			customerVisit = findById(customerVisitDTO.getId());
			customerVisit.setDate(customerVisitDTO.getDate());
			customerVisit.setTime(customerVisitDTO.getTime());
			customerVisit.setPlace(customerVisitDTO.getPlace());
			
			CustomerDiaryDTO customerDiaryDTO = customerDairyService.findByCustomerDiaryId(customerVisitDTO.getCustomerDiaryId());
			customerVisit.setCustomerDiary(customerDairyService.mapDTOToCustomerDiaryEntity(customerDiaryDTO));
			
			CustomerDTO customerDTO = customerService.findByCustomerId(customerVisitDTO.getCustomerId());
			customerVisit.setCustomer(customerService.mapDTOToCustomerEntity(customerDTO));			
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
		CustomerVisitDTO tempCustomerVisitDTO = new CustomerVisitDTO();
		if (customerVisit != null) {
			tempCustomerVisitDTO = modelMapper.map(customerVisit, tempCustomerVisitDTO.getClass());
		}
		return tempCustomerVisitDTO;
	}
	
	
	private List<CustomerVisitDTO> mapCustomerVisitLineEntityToDTO(final List<CustomerVisit> CustomerVisitListt) {
		return (List<CustomerVisitDTO>) mapEntitiesToDTOs(CustomerVisitListt, CustomerVisitDTO.class);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerVisit> findAll() {
		return genericRepository.findAll(CustomerVisit.class);
	}

	@Override
	@Transactional
	public CustomerVisit createOrUpdateCustomerVisit(final CustomerVisitDTO customerVisitDTO) {		
		if(customerVisitDTO == null)
			return null;
		CustomerVisit userContact = mapDTOToCustomerVisitEntity(customerVisitDTO);
		Long id = customerVisitDTO.getId();		
		if(id != null && id > 0) {
			genericRepository.saveOrUpdate(userContact);
		}else {			
			id = (Long) genericRepository.save(userContact);
		}
		userContact = genericRepository.findById(CustomerVisit.class, id);
		return userContact;
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