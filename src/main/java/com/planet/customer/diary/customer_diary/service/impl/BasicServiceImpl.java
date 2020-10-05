package com.planet.customer.diary.customer_diary.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planet.customer.diary.customer_diary.entity.BaseEntity;
import com.planet.customer.diary.customer_diary.model.dto.BaseDTO;

@Service(value = "basicService")
public class BasicServiceImpl {
	
	@Autowired
	private ModelMapper modelMapper;
	
	protected BaseEntity mapDTOToEntity(final BaseDTO baseDTO , BaseEntity baseEntity){
		if (baseDTO != null) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			baseEntity = modelMapper.map(baseDTO, baseEntity.getClass());
		}
		return baseEntity;
	}

}
