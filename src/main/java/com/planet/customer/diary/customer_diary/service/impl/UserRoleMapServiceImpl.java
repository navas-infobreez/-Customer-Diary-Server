package com.planet.customer.diary.customer_diary.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.entity.UserRole;
import com.planet.customer.diary.customer_diary.entity.UserRoleMap;
import com.planet.customer.diary.customer_diary.model.dto.UserRoleDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.repository.UserRoleMapRepository;
import com.planet.customer.diary.customer_diary.service.UserRoleMapService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class UserRoleMapServiceImpl extends BasicServiceImpl implements UserRoleMapService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Autowired
	private UserRoleMapRepository userRoleMapRepository;
	
	@Override
	public List<UserRoleMap> findByUserId(Long id) {
		final List<UserRoleMap> userRoleList = userRoleMapRepository.findByUserId(id);
		return userRoleList != null && userRoleList.isEmpty() ? null :userRoleList;	
	}


	@Override
	public List<UserRoleMap> mapUserRoleMapDTOToEntity(List<UserRoleDTO> roles,User user) {
		List<UserRoleMap>  actualRoleMaps = user.getUserRoleMaps() ;	
		final List<UserRoleMap> tempRoles = new ArrayList<>();
		for (final UserRoleDTO userRoleDTO : roles) {
			final UserRoleMap userRoleMap = actualRoleMaps != null && actualRoleMaps.size() > 0 ?
					actualRoleMaps.stream().filter(aUserRoleMap -> aUserRoleMap.getUserRole().getId().equals(userRoleDTO.getId())).
					findFirst().get() : new UserRoleMap();
			if(userRoleMap.getUser() == null || userRoleMap.getUserRole() == null) {
				userRoleMap.setUser(user);
				userRoleMap.setUserRole(genericRepository.findById(UserRole.class, userRoleDTO.getId()));
			}
			tempRoles.add(userRoleMap);
		}
		return tempRoles;
	}
	
	
}