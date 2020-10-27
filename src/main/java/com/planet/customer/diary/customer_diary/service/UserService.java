package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.User;
import  com.planet.customer.diary.customer_diary.model.dto.UserDTO;

public interface UserService {

	UserDTO createOrUpdateUser(UserDTO user);

	List<UserDTO> findAll();

	UserDTO findByUserName(String username);

	UserDTO findByUserId(Long id);

	//UserDTO update(UserDTO userDTO);

	void delete(Long id);

	public User mapDTOToUserEntity(final UserDTO userDTO);
}