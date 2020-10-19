package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.entity.ProductCategory;
import com.planet.customer.diary.customer_diary.model.dto.ProductCategoryDTO;

public interface ProductCategoryService {

	public List<ProductCategoryDTO> findAll();

	public ProductCategoryDTO findCategoryId(Long id);

	public ProductCategoryDTO createOrUpdateProductCategory(ProductCategoryDTO productCategoryDTO,
			Product product);
	
	public ProductCategory mapProductCategoryDTOToEntity(ProductCategoryDTO productCategoryDTO,
			Product product);

	public void delete(Long id);
	
}