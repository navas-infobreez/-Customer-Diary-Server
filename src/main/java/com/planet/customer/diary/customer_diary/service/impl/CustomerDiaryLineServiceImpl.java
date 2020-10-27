package com.planet.customer.diary.customer_diary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.CustomerDiaryLine;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryLineDTO;
import com.planet.customer.diary.customer_diary.model.dto.ProductCategoryDTO;
import com.planet.customer.diary.customer_diary.model.dto.ProductDTO;
import com.planet.customer.diary.customer_diary.model.dto.UomDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryLineRepository;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryLineService;
import com.planet.customer.diary.customer_diary.service.ProductCategoryService;
import com.planet.customer.diary.customer_diary.service.ProductService;
import com.planet.customer.diary.customer_diary.service.UomService;

@Service(value = "customerDiaryLineService")
public class CustomerDiaryLineServiceImpl extends BasicServiceImpl implements CustomerDiaryLineService {

	@Autowired
	private GenericRepository genericRepository;

	@Autowired
	@Qualifier("customerDiaryLineRepository")
	private CustomerDiaryLineRepository customerDiaryLineRepository;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private UomService uomService;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@Override
	public List<CustomerDiaryLine> mapCustomerDiaryLineDTOToEntity(final List<CustomerDiaryLineDTO> customerDiaryLineDTOList,
			final CustomerDiary customerDiary) {
		List<CustomerDiaryLine> tempCustomerDiaryLineList  = null;
		if(customerDiaryLineDTOList == null) {
			if(customerDiary.getId() != null && customerDiary.getId() > 0) {
				tempCustomerDiaryLineList = customerDiaryLineRepository.findByCustomerDiaryId(customerDiary.getId());
			}
			return tempCustomerDiaryLineList;
		}
		tempCustomerDiaryLineList = new ArrayList<>();
		for (final CustomerDiaryLineDTO customerDiaryLineDTO : customerDiaryLineDTOList) {
			CustomerDiaryLine customerDiaryLine = !customerDiaryLineDTO.isEmpty() ? findById(customerDiaryLineDTO.getId())
					: new CustomerDiaryLine();
			customerDiaryLine.setSalesPrice(customerDiaryLineDTO.getSalesPrice());
			customerDiaryLine.setQty(customerDiaryLineDTO.getQty());
			customerDiaryLine.setDescription(customerDiaryLineDTO.getDescription());
			
			ProductDTO productDTO = productService.findByProductId(customerDiaryLineDTO.getProductId());
			customerDiaryLine.setProduct( productService.mapDTOToProductEntity(productDTO));
			
			UomDTO uomDTO = uomService.findUomId(customerDiaryLineDTO.getUomId());
			customerDiaryLine.setUom(uomService.mapUomDTOToEntity(uomDTO, customerDiaryLine.getUom()));
			
			ProductCategoryDTO productCategoryDTO = productCategoryService.findCategoryId(customerDiaryLineDTO.getProductCategoryId());
			customerDiaryLine.setProductCategory( productCategoryService
					.mapProductCategoryDTOToEntity(productCategoryDTO, customerDiaryLine.getProductCategory()));
			
			if (customerDiaryLine.getCustomerDiary() == null) {
				customerDiaryLine.setCustomerDiary(customerDiary);
			}
			tempCustomerDiaryLineList.add(customerDiaryLine);
		}
		return tempCustomerDiaryLineList;
	}

	private CustomerDiaryLine findById(final Long id) {
		return genericRepository.findById(CustomerDiaryLine.class, id);
	}
	
	private List<CustomerDiaryLineDTO> mapCustomerDiaryLineEntityToDTO(final List<CustomerDiaryLine> CustomerDiaryLineList) {
		return (List<CustomerDiaryLineDTO>) mapEntitiesToDTOs(CustomerDiaryLineList, CustomerDiaryLineDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryLineDTO> findByCustomerDiaryId(Long id) {
		final List<CustomerDiaryLine> customerDiaryLineList = customerDiaryLineRepository.findByCustomerDiaryId(id);
		return mapCustomerDiaryLineEntityToDTO(customerDiaryLineList);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryLineDTO> findByProductId(Long productId) {
		final List<CustomerDiaryLine> customerDiaryLineList = customerDiaryLineRepository.findByProductId(productId);
		return mapCustomerDiaryLineEntityToDTO(customerDiaryLineList);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryLineDTO> findByProductCategoryId(Long productCategoryId) {
		final List<CustomerDiaryLine> customerDiaryLineList = customerDiaryLineRepository.findByProductCategoryId(productCategoryId);
		return mapCustomerDiaryLineEntityToDTO(customerDiaryLineList);
	}

}