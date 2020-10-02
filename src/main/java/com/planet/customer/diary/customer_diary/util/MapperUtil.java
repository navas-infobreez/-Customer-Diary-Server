package com.planet.customer.diary.customer_diary.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.planet.customer.diary.customer_diary.entity.BaseEntity;
import com.planet.customer.diary.customer_diary.model.dto.BaseDTO;

@Component
@Scope("prototype")
public class MapperUtil {

	@Autowired
	private ModelMapper modelMapper;

	public <E extends BaseEntity, T extends BaseDTO> List<T> mapBaseEntitiesToDTOs(final List<E> baseEntities,
			final T baseDTO) {
		List<T> baseDTOs = new ArrayList<>();
		if (!baseEntities.isEmpty()) {
			baseDTOs = baseEntities.stream().map(baseEntity -> mapBaseEntityToDTO(baseEntity, baseDTO))
					.collect(Collectors.toList());
		}
		return baseDTOs;
	}

	public <E extends BaseEntity, T extends BaseDTO> List<E> mapBaseDTOsToEntities(final List<T> baseDTOs,
			final E baseEntity) {
		List<E> baseEntities = new ArrayList<>();
		if (!baseDTOs.isEmpty()) {
			baseEntities = baseDTOs.stream().map(baseDTO -> mapDTOToBaseEntity(baseDTO, baseEntity))
					.collect(Collectors.toList());
		}
		return baseEntities;
	}

	@SuppressWarnings("unchecked")
	public <E extends BaseEntity, T extends BaseDTO> T mapBaseEntityToDTO(final E baseEntity, final T baseDTO) {
		final T tempBaseDTO = baseDTO;
		if (baseEntity != null) {
			return (T) modelMapper.map(baseEntity, tempBaseDTO.getClass());
		}
		return tempBaseDTO;
	}

	@SuppressWarnings("unchecked")
	public <E extends BaseEntity, T extends BaseDTO> E mapDTOToBaseEntity(final T baseDTO, final E baseEntity) {
		final E tempBaseEntity = baseEntity;
		if (baseDTO != null) {
			return (E) modelMapper.map(baseDTO, baseEntity.getClass());
		}
		return tempBaseEntity;
	}

	public <E extends BaseEntity, T extends BaseDTO> void setEntityToDTOMapping(final PropertyMap<E, T> propertyMap) {
		modelMapper.addMappings(propertyMap);
	}

	public <E extends BaseEntity, T extends BaseDTO> void setDTOToEntityMapping(final PropertyMap<T, E> propertyMap) {
		modelMapper.addMappings(propertyMap);
	}

}
