package com.planet.customer.diary.customer_diary.repository;


import java.util.List;

import com.planet.customer.diary.customer_diary.entity.Product;

public interface ProductRepository {

	public List<Product> getAllActiveProduct();

	public List<Product> findByProductCategoryId(Long categoryId);
}
