package com.planet.customer.diary.customer_diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.entity.UserContact;
import com.planet.customer.diary.customer_diary.model.dto.UserContactDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.UserContactService;

@Service
public class UserContactServiceImpl extends BasicServiceImpl implements UserContactService {

	@Autowired
	private GenericRepository genericRepository;
	
	
	
	@Override
	public List<UserContact> findAll() {
		return genericRepository.findAll(UserContact.class);
	}

	@Override
	@Transactional(readOnly = true)
	public UserContact createOrUpdateUserContact(final UserContactDTO userContactDTO,User user) {		
		if(userContactDTO == null)
			return null;
		UserContact userContact = mapUserContactDTOToEntity(userContactDTO,user);
		Long id = userContactDTO.getId();		
		if(id != null && id > 0) {
			genericRepository.saveOrUpdate(userContact);
		}else {			
			id = (Long) genericRepository.save(userContact);
		}
		userContact = genericRepository.findById(UserContact.class, id);
		return userContact;
	}
	
	
	public UserContact mapUserContactDTOToEntity(UserContactDTO userContactDTO,User user){
		UserContact userContact = null;
		if(user.getUserContact() != null) {
			userContact = user.getUserContact();
			userContact.setPhoneNumber(userContactDTO.getPhoneNumber());
			userContact.setEmail(userContactDTO.getEmail());
			userContact.setCountry(userContactDTO.getCountry());
			userContact.setCity(userContactDTO.getCity());
			userContact.setAddress1(userContactDTO.getAddress1());
			userContact.setAddress2(userContactDTO.getAddress2());
		}
		else {
			userContact = new UserContact();
			userContact = (UserContact) super.mapDTOToEntity(userContactDTO, userContact);
		}
		userContact.setUser(user);
		return userContact;
	}
	
	
}