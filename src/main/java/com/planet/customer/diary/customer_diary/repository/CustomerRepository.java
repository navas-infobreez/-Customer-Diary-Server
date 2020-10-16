package com.planet.customer.diary.customer_diary.repository;


import com.planet.customer.diary.customer_diary.entity.Customer;

public interface CustomerRepository {

	Customer findBySearchKey(String searchKey);

}
