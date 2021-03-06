package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.model.dto.ProductDTO;

public interface ProductService {

	ProductDTO createOrUpdateProduct(ProductDTO productDTO);

	List<ProductDTO> findAll();

	List<ProductDTO> getAllActiveProduct();

	ProductDTO findByProductId(Long id);

	List<ProductDTO> findByProductCategoryId(Long categoryId);

	Product mapDTOToProductEntity(final ProductDTO productDTO);
	
	void delete(Long id);

}