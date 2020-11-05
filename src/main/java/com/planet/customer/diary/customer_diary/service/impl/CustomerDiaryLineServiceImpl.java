package com.planet.customer.diary.customer_diary.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.CustomerDiaryLine;
import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.entity.ProductCategory;
import com.planet.customer.diary.customer_diary.entity.UOM;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryLineDTO;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryLineRepository;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryLineService;

@Service(value = "customerDiaryLineService")
public class CustomerDiaryLineServiceImpl extends BasicServiceImpl implements CustomerDiaryLineService {

	@Autowired
	private GenericRepository genericRepository;

	@Autowired
	@Qualifier("customerDiaryLineRepository")
	private CustomerDiaryLineRepository customerDiaryLineRepository;

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
			Product product = genericRepository.findById(Product.class, customerDiaryLineDTO.getProductId());
			if (product == null)
				throw new EntityNotFoundException("Product" + customerDiaryLineDTO.getProductId() + " not found");
			customerDiaryLine.setProduct(product);
			UOM uom = genericRepository.findById(UOM.class, customerDiaryLineDTO.getUomId());
			if (uom == null)
				throw new EntityNotFoundException("uom" + customerDiaryLineDTO.getUomId() + " not found");
			customerDiaryLine.setUom(uom);
			ProductCategory productCategory = genericRepository.findById(ProductCategory.class,
					customerDiaryLineDTO.getProductCategoryId());
			if (productCategory == null)
				throw new EntityNotFoundException(
						"ProductCategory" + customerDiaryLineDTO.getProductCategoryId() + " not found");
			customerDiaryLine.setProductCategory(productCategory);
			
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
	
	public List<CustomerDiaryLineDTO> mapCustomerDiaryLineEntityToDTO(
			final List<CustomerDiaryLine> customerDiaryLineList) {
		List<CustomerDiaryLineDTO> tempDTOs = null;
		if (customerDiaryLineList != null && !customerDiaryLineList.isEmpty()) {
			tempDTOs = customerDiaryLineList.stream().map(this::mapCustomerDiaryLineEntityToDTO)
					.collect(Collectors.toList());
		}
		return tempDTOs;
	}

	private CustomerDiaryLineDTO mapCustomerDiaryLineEntityToDTO(CustomerDiaryLine customerDiaryLine) {
		CustomerDiaryLineDTO customerDiaryLineDTO = mapEntityToDTO(customerDiaryLine, CustomerDiaryLineDTO.class);
		customerDiaryLineDTO.setProductCategoryId(customerDiaryLine.getProductCategory().getId());
		customerDiaryLineDTO.setUomId(customerDiaryLine.getUom().getId());
		customerDiaryLineDTO.setProductId(customerDiaryLine.getProduct().getId());
		return customerDiaryLineDTO;
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