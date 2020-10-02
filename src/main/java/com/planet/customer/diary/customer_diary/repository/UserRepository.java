package com.planet.customer.diary.customer_diary.repository;


import com.planet.customer.diary.customer_diary.entity.User;

public interface UserRepository {

	User findByUserName(String username);

}
