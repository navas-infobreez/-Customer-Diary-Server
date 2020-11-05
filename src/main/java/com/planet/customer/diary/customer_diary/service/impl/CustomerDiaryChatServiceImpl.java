package com.planet.customer.diary.customer_diary.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.CustomerDiary;
import com.planet.customer.diary.customer_diary.entity.CustomerDiaryChat;
import com.planet.customer.diary.customer_diary.entity.User;
import com.planet.customer.diary.customer_diary.model.dto.CustomerDiaryChatDTO;
import com.planet.customer.diary.customer_diary.repository.CustomerDiaryChatRepository;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.CustomerDiaryChatService;

@Service(value = "customerDiaryChatService")
public class CustomerDiaryChatServiceImpl extends BasicServiceImpl implements CustomerDiaryChatService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Autowired
	private CustomerDiaryChatRepository customerDiaryChatRepository;


	private CustomerDiaryChat findById(final Long id) {
		return genericRepository.findById(CustomerDiaryChat.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryChatDTO> findByCustomerDiaryId(Long diaryId) {
		return mapCustomerDiaryChatToDTO(customerDiaryChatRepository.findByCustomerDiaryId(diaryId));
	}

	@Override
	@Transactional
	public List<CustomerDiaryChatDTO> createOrUpdateCustomerDiaryChat(
			List<CustomerDiaryChatDTO> customerDiaryChatList) {
		return customerDiaryChatList.stream()
				.map(this::createOrUpdateCustomerDiaryChat)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDiaryChatDTO> findByCustomerDiaryList(List<Long> diaryIds) {
		return mapCustomerDiaryChatToDTO(customerDiaryChatRepository.findByCustomerDiaryIds(diaryIds));
	}

	private List<CustomerDiaryChatDTO> mapCustomerDiaryChatToDTO(final List<CustomerDiaryChat> customerDiaryChat) {
		List<CustomerDiaryChatDTO> tempDTOs = null;
		if (!customerDiaryChat.isEmpty()) {
			tempDTOs = customerDiaryChat.stream().map(this::mapCustomerDiaryChatToDTO).collect(Collectors.toList());
		}
		return tempDTOs;
	}

	private CustomerDiaryChatDTO mapCustomerDiaryChatToDTO(final CustomerDiaryChat customerDiaryChat) {
		CustomerDiaryChatDTO customerDiaryChatDTO = mapEntityToDTO(customerDiaryChat, CustomerDiaryChatDTO.class);
		customerDiaryChatDTO.setCustomerDiaryId(customerDiaryChat.getCustomerDiary().getId());
		customerDiaryChatDTO.setUserId(customerDiaryChat.getUser().getId());
		return customerDiaryChatDTO;
	}

	private CustomerDiaryChatDTO createOrUpdateCustomerDiaryChat(CustomerDiaryChatDTO customerDiaryChatDto) {
		if (customerDiaryChatDto == null)
			return null;
		CustomerDiaryChat customerDiaryChat = mapDTOToCustomerDiaryChatEntity(customerDiaryChatDto);
		Long id = customerDiaryChatDto.getId();
		if (!customerDiaryChatDto.isEmpty()) {
			genericRepository.saveOrUpdate(customerDiaryChat);
		} else {
			id = (Long) genericRepository.save(customerDiaryChat);
		}
		return mapCustomerDiaryChatToDTO(findById(id));
	}

	private CustomerDiaryChat mapDTOToCustomerDiaryChatEntity(CustomerDiaryChatDTO customerDiaryChatDto) {
		CustomerDiaryChat customerDiaryChat = null;
		if (!customerDiaryChatDto.isEmpty()) {
			customerDiaryChat = findById(customerDiaryChatDto.getId());
			CustomerDiary customerDiary = genericRepository.findById(CustomerDiary.class,
					customerDiaryChatDto.getCustomerDiaryId());
			if (customerDiary == null)
				throw new EntityNotFoundException("CustomerDiary not found");
			User user = genericRepository.findById(User.class, customerDiaryChatDto.getUserId());
			if (user == null)
				throw new EntityNotFoundException("User not found");
			customerDiaryChat.setCustomerDiary(customerDiary);
			customerDiaryChat.setUser(user);
			customerDiaryChat.setMessage(customerDiaryChatDto.getMessage());
		} else {
			customerDiaryChat = new CustomerDiaryChat();
			customerDiaryChat = (CustomerDiaryChat) mapDTOToEntity(customerDiaryChatDto, customerDiaryChat);
		}
		return customerDiaryChat;
	}
	
}