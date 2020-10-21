package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.ProductCategory;
import com.planet.customer.diary.customer_diary.model.dto.ProductCategoryDTO;

public interface ProductCategoryService {

	public List<ProductCategoryDTO> findAll();

	public ProductCategoryDTO findCategoryId(Long id);

	public ProductCategory findbyProductCategoryId(Long id);

	public ProductCategoryDTO createOrUpdateProductCategory(ProductCategoryDTO productCategoryDTO);
	
	public ProductCategory mapProductCategoryDTOToEntity(ProductCategoryDTO productCategoryDTO,
			ProductCategory productCategory);

	public void delete(Long id);
	
}