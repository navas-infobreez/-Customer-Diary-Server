package com.planet.customer.diary.customer_diary.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDTO;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryDTO;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryLineDTO;
import com.planet.customer.diary.customer_diary.model.dto.ProductCategoryDTO;
import com.planet.customer.diary.customer_diary.model.dto.ProductDTO;
import com.planet.customer.diary.customer_diary.model.dto.UomDTO;
import com.planet.customer.diary.customer_diary.model.dto.UserDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryRepository;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryLineService;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryService;
import com.planet.customer.diary.customer_diary.service.CustomerService;
import com.planet.customer.diary.customer_diary.service.ProductCategoryService;
import com.planet.customer.diary.customer_diary.service.ProductService;
import com.planet.customer.diary.customer_diary.service.UomService;
import com.planet.customer.diary.customer_diary.service.UserService;

@Service(value = "customerDiaryService")
public class CustomerDiaryServiceImpl extends BasicServiceImpl implements CustomerDiaryService {
		
	@Autowired
	@Qualifier("genericRepository")
	private GenericRepository genericRepository;

	@Autowired
	@Qualifier("customerDiaryRepository")
	private CustomerDiaryRepository customerDiaryRepository;

	@Autowired
	private CustomerDiaryLineService customerDiaryLineService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	private List<CustomerDiaryDTO> mapCustomerDiaryEntityToDTO(final List<CustomerDiary> customerDiaryList) {
		List<CustomerDiaryDTO> tempDTOs = null;
		if (!customerDiaryList.isEmpty()) {
			tempDTOs = customerDiaryList.stream().map(this::mapCustomerDiaryEntityToDTO)
					.collect(Collectors.toList());
		}
		return tempDTOs;
	}

	private CustomerDiaryDTO mapCustomerDiaryEntityToDTO(final CustomerDiary customerDiary) {
		CustomerDiaryDTO customerDiaryDTO = mapEntityToDTO(customerDiary, CustomerDiaryDTO.class);
		final List<CustomerDiaryLineDTO> customerDiaryLineDTOList = (List<CustomerDiaryLineDTO>) mapEntitiesToDTOs(
				customerDiary.getCustomerDiaryLineList(), CustomerDiaryLineDTO.class);
		customerDiaryDTO.setCustomerDiaryLineDTOList(customerDiaryLineDTOList);
		return customerDiaryDTO;
	}

	public CustomerDiary mapDTOToCustomerDiaryEntity(final CustomerDiaryDTO customerDiaryDTO) {
		CustomerDiary customerDiary = null;
		if (customerDiaryDTO.getId() != null && customerDiaryDTO.getId() > 0) {
			customerDiary = findById(customerDiaryDTO.getId());
			customerDiary.setQuotationNo(customerDiaryDTO.getQuotationNo());
			customerDiary.setActive(customerDiaryDTO.isActive());
			customerDiary.setDescription(customerDiaryDTO.getDescription());
			customerDiary.setCreatedDate(customerDiaryDTO.getCreatedDate());
			customerDiary.setDiaryDate(customerDiaryDTO.getDiaryDate());
			customerDiary.setDocumentNo(customerDiaryDTO.getDocumentNo());
			//customerDiary.setShiptoCustomerAddress(customerDiaryDTO.getShiptoCustomerAddress);
			customerDiary.setTotalAmount(customerDiaryDTO.getTotalAmount());
			customerDiary.setEmail(customerDiaryDTO.getEmail());
			customerDiary.setCountry(customerDiaryDTO.getCountry());
			customerDiary.setCity(customerDiaryDTO.getCity());
			customerDiary.setState(customerDiaryDTO.getState());
			customerDiary.setLandmark(customerDiaryDTO.getLandmark());
			customerDiary.setPinNo(customerDiaryDTO.getPinNo());
			customerDiary.setAddress1(customerDiaryDTO.getAddress1());
			customerDiary.setAddress2(customerDiaryDTO.getAddress2());
			customerDiary.setContactNo(customerDiaryDTO.getContactNo());
			customerDiary.setPurpose(customerDiaryDTO.getPurpose());
			customerDiary.setStatus(customerDiaryDTO.getStatus());
			
			CustomerDTO customerDTO = customerService.findByCustomerId(customerDiaryDTO.getCustomerId());
			customerDiary.setCustomer(customerService.mapDTOToCustomerEntity(customerDTO));
			
			UserDTO userDTO = userService.findByUserId(customerDiaryDTO.getSalesRepId());
			customerDiary.setSalesRep(userService.mapDTOToUserEntity(userDTO));
			
		}else {
			customerDiary = new CustomerDiary();
			customerDiary = (CustomerDiary) mapDTOToEntity(customerDiaryDTO, customerDiary);
		}
		customerDiary.setCustomerDiaryLineList(
				customerDiaryLineService.mapCustomerDiaryLineDTOToEntity(customerDiaryDTO.getCustomerDiaryLineDTOList(), customerDiary));
		return customerDiary;
	}

	private CustomerDiary findById(final Long id) {
		return genericRepository.findById(CustomerDiary.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryDTO> findAll() {
		final List<CustomerDiary> customerDiaryList = genericRepository.findAll(CustomerDiary.class);
		return mapCustomerDiaryEntityToDTO(customerDiaryList);
	}

	@Override
	@Transactional
	public void delete(final Long id) {
		final CustomerDiary userRole = findById(id);
		if (userRole != null) {
			genericRepository.delete(userRole);
		}
	}

	
	@Override
	@Transactional(readOnly = true)
	public CustomerDiaryDTO findByCustomerDiaryId(Long id) {
		final CustomerDiary customerDiary = findById(id);
		return mapCustomerDiaryEntityToDTO(customerDiary);
	}

	@Override
	@Transactional
	public CustomerDiaryDTO createOrUpdateCustomerDiary(CustomerDiaryDTO customerDiaryDTO) {
		if (customerDiaryDTO == null)
			throw new NullPointerException("No data found user role information");
		if (customerDiaryDTO.getId() != null && customerDiaryDTO.getId() > 0) {
			genericRepository.saveOrUpdate(mapDTOToCustomerDiaryEntity(customerDiaryDTO));
		}else {
			final Serializable userId = genericRepository.save(mapDTOToCustomerDiaryEntity(customerDiaryDTO));
			customerDiaryDTO.setId((Long) userId);
		}					
		return mapCustomerDiaryEntityToDTO(findById(customerDiaryDTO.getId()));
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryDTO> getAllActiveCustomerDiary() {
		List<CustomerDiary> allActiveCustomerDiary = customerDiaryRepository.getAllActiveCustomerDiary();
		return mapCustomerDiaryEntityToDTO(allActiveCustomerDiary);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryDTO> findBySalesRepId(Long salesrepId){
		final List<CustomerDiary> customerDiary = customerDiaryRepository.findBySalesRepId(salesrepId);
		return mapCustomerDiaryEntityToDTO(customerDiary);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryDTO> findByCustomerId(Long customerId){
		final List<CustomerDiary> customerDiary = customerDiaryRepository.findByCustomerId(customerId);
		return mapCustomerDiaryEntityToDTO(customerDiary);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryDTO> findByDocumentNo(String documentno){
		final List<CustomerDiary> customerDiary = customerDiaryRepository.findByDocumentNo(documentno);
		return mapCustomerDiaryEntityToDTO(customerDiary);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryDTO> findByInvoiceNo(String invoiceno){
		final List<CustomerDiary> customerDiary = customerDiaryRepository.findByInvoiceNo(invoiceno);
		return mapCustomerDiaryEntityToDTO(customerDiary);
	}
}