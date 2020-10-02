package com.planet.customer.diary.customer_diary.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.entity.UserRole;
import com.planet.customer.diary.customer_diary.model.dto.UserDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.repository.UserRepository;
import com.planet.customer.diary.customer_diary.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("genericRepository")
	private GenericRepository genericRepository;

	@Autowired
	private ModelMapper modelMapper;

	private List<SimpleGrantedAuthority> getAuthority(final User user) {
		final List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		user.getUserRoleMaps().forEach(roleMap -> {
			final UserRole userRole = roleMap.getUserRole();
			if (userRole.isActive().booleanValue()) {
				simpleGrantedAuthorities.add(new SimpleGrantedAuthority(userRole.getName()));
			}
		});
		return simpleGrantedAuthorities;
	}

	private List<UserDTO> mapUserEntitiesToDTOs(final List<User> users) {
		List<UserDTO> userDTOs = new ArrayList<>();
		if (!users.isEmpty()) {
			userDTOs = users.stream().map(this::mapUserEntityToDTO).collect(Collectors.toList());
		}
		return userDTOs;
	}

	private UserDTO mapUserEntityToDTO(final User user) {
		UserDTO tempUserDTO = new UserDTO();
		if (user != null) {
			tempUserDTO = modelMapper.map(user, tempUserDTO.getClass());
			final String password = user.getPassword();
//			if(password != null) {
//				tempUserDTO.setPassword(password.);
//			}
			tempUserDTO.mapUserContact(user);
			tempUserDTO.mapUserRoles(user);
		}
		return tempUserDTO;
	}

	private User mapDTOToUserEntity(final UserDTO userDTO) {
		User user = new User();
		if (userDTO != null) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			user = modelMapper.map(userDTO, user.getClass());
			final String password = userDTO.getPassword();
			if(password != null) 
				user.setPassword(passwordEncoder.encode(password));
			user.setUserContact(userDTO.getUserContact(userDTO.getUserContact()));
			user.setUserRoleMaps(userDTO.getUserRoles(user, userDTO.getRoles()));
		}
		return user;
	}

	private User findById(final Long id) {
		return genericRepository.findById(User.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		final List<User> users = genericRepository.findAll(User.class);
		return mapUserEntitiesToDTOs(users);
	}

	@Override
	@Transactional
	public void delete(final Long id) {
		final User user = findById(id);
		if (user != null) {
			genericRepository.delete(user);
		}
	}

	@Override
	@Transactional
	public UserDTO createOrUpdateUser(final UserDTO userDTO) {
		if(userDTO == null)
			throw new NullPointerException("No data found user information");
		User user = null;
		if(userDTO.getId() != null && userDTO.getId() > 0) {
			//user = findById(userDTO.getId());
			genericRepository.saveOrUpdate(mapDTOToUserEntity(userDTO));
		}else {
			final Serializable userId = genericRepository.save(mapDTOToUserEntity(userDTO));
			userDTO.setId((Long) userId);
		}
		
			
		return userDTO;
	}

//	@Override
//	@Transactional
//	public UserDTO save(final UserDTO userDTO) {
//		if (userDTO != null) {
//			final Serializable userId = genericRepository.save(mapDTOToUserEntity(userDTO));
//			userDTO.setId((Long) userId);
//		}
//		return userDTO;
//	}

	@Override
	@Transactional//(readOnly = true)
	public UserDTO findByUserName(final String username) {
		final User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password!");
		}
		return mapUserEntityToDTO(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findByUserId(final Long id) {
		final User user = genericRepository.findById(User.class, id);
		return mapUserEntityToDTO(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) {
		final User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password!");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthority(user));
	}

}