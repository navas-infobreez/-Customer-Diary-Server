package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.entity.UserRoleMap;
import com.planet.customer.diary.customer_diary.model.dto.UserRoleDTO;

public interface UserRoleMapService {

	public List<UserRoleMap> findByUserId(Long id);
	
	public List<UserRoleMap>  mapUserRoleMapDTOToEntity(final List<UserRoleDTO> roles,final User user);
}