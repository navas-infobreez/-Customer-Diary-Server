package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.Product;
import com.planet.customer.diary.customer_diary.entity.ProductPrice;
import com.planet.customer.diary.customer_diary.model.dto.ProductPriceDTO;

public interface ProductPriceService {

	public List<ProductPriceDTO> findByProductId(Long id);
	
	public List<ProductPrice> mapProductPriceDTOToEntity(final List<ProductPriceDTO> productPriceDTOList,
			final Product product);
}