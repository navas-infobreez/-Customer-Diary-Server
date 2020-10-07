package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.model.dto.UserRoleDTO;

public interface UserRoleService {

	UserRoleDTO createOrUpdateUserRole(UserRoleDTO userRole);

	List<UserRoleDTO> findAll();

	UserRoleDTO findByRoleId(Long id);

	void delete(Long id);

}