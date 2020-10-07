package com.planet.customer.diary.customer_diary.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.UserRole;
import com.planet.customer.diary.customer_diary.model.dto.UserRoleDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.UserRoleService;

@Service(value = "userRoleService")
public class UserRoleServiceImpl extends BasicServiceImpl implements UserRoleService {
		
	@Autowired
	@Qualifier("genericRepository")
	private GenericRepository genericRepository;
				
	@Autowired
	private ModelMapper modelMapper;
	
	private List<UserRoleDTO> mapUserEntitiesToDTOs(final List<UserRole> usersRoleList) {
		List<UserRoleDTO> userRoleDTOs = new ArrayList<>();
		if (!usersRoleList.isEmpty()) {
			userRoleDTOs = usersRoleList.stream().map(this::mapUserEntityToDTO).collect(Collectors.toList());
		}
		return userRoleDTOs;
	}

	private UserRoleDTO mapUserEntityToDTO(final UserRole userRole) {
		UserRoleDTO tempUserRoleDTO = new UserRoleDTO();
		if (userRole != null) 
			tempUserRoleDTO = modelMapper.map(userRole, tempUserRoleDTO.getClass());			
		return tempUserRoleDTO;
	}

	private UserRole mapDTOToUserEntity(final UserRoleDTO userRoleDTO) {
		UserRole userRole = null;	
		if(userRoleDTO.getId() != null && userRoleDTO.getId() > 0) {
			userRole = findById(userRoleDTO.getId());
			userRole.setActive(userRoleDTO.getActive());
			userRole.setDescription(userRoleDTO.getDescription());
			userRole.setName(userRoleDTO.getName());
			userRole.setPriority(userRoleDTO.getPriority());
		}else {
			userRole = new UserRole();
			userRole = (UserRole) mapDTOToEntity(userRoleDTO, userRole);
		}						
		return userRole;
	}

	private UserRole findById(final Long id) {
		return genericRepository.findById(UserRole.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserRoleDTO> findAll() {
		final List<UserRole> userRoles = genericRepository.findAll(UserRole.class);
		return mapUserEntitiesToDTOs(userRoles);
	}

	@Override
	@Transactional
	public void delete(final Long id) {
		final UserRole userRole = findById(id);
		if (userRole != null) {
			genericRepository.delete(userRole);
		}
	}

	
	@Override
	@Transactional(readOnly = true)
	public UserRoleDTO findByRoleId(final Long id) {
		final UserRole userRole =  findById(id);
		return mapUserEntityToDTO(userRole);
	}

	@Override
	@Transactional
	public UserRoleDTO createOrUpdateUserRole(UserRoleDTO userRole) {
		if(userRole == null)
			throw new NullPointerException("No data found user role information");
		if(userRole.getId() != null && userRole.getId() > 0) {
			genericRepository.saveOrUpdate(mapDTOToUserEntity(userRole));
		}else {
			final Serializable userId = genericRepository.save(mapDTOToUserEntity(userRole));
			userRole.setId((Long) userId);
		}					
		return userRole;
	}
	
}