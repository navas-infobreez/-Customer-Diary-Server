package com.planet.customer.diary.customer_diary.repository;


import java.util.List;

import com.planet.customer.diary.customer_diary.entity.UserRoleMap;

public interface UserRoleMapRepository {

	List<UserRoleMap> findByUserId(Long userId);
	
	UserRoleMap findUserRoleMapbyRoleId(Long userId, Long roleId);

}
