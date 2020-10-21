package com.planet.customer.diary.customer_diary.repository;


import java.util.List;

import com.planet.customer.diary.customer_diary.entity.ProductPrice;

public interface ProductPriceRepository {

	public List<ProductPrice> findByProductId(Long productId);

}
