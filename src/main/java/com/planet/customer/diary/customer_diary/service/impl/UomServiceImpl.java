package com.planet.customer.diary.customer_diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.planet.customer.diary.customer_diary.entity.UOM;
import com.planet.customer.diary.customer_diary.model.dto.UomDTO;
import com.planet.customer.diary.customer_diary.repository.GenericRepository;
import com.planet.customer.diary.customer_diary.service.UomService;

@Service(value = "uomService")
public class UomServiceImpl extends BasicServiceImpl implements UomService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<UomDTO> findAll() {
		return mapUOMEntitiesToDTOs(genericRepository.findAll(UOM.class));
	}

	
	private List<UomDTO> mapUOMEntitiesToDTOs(List<UOM> uomList) {
		List<UomDTO> productCategoryDTOList = (List<UomDTO>) mapEntitiesToDTOs(uomList, UomDTO.class);
		return productCategoryDTOList;
	}

	public UOM mapUomDTOToEntity(UomDTO uomDTO, UOM uom) {
		if (uom != null && uom.getId() > 0) {
			uom.setActive(uomDTO.isActive());
			uom.setDescription(uomDTO.getDescription());
			uom.setSearchKey(uomDTO.getSearchKey());
			uom.setName(uomDTO.getName());
		} else {
			uom = new UOM();
			uom = (UOM) super.mapDTOToEntity(uomDTO, uom);
		}
		return uom;
	}

	@Override
	@Transactional(readOnly = true)
	public UomDTO createOrUpdateUom(final UomDTO uomDTO) {
		if (uomDTO == null)
			return null;
		Long id = uomDTO.getId();
		if(id != null && id > 0) {
			UOM uom = mapUomDTOToEntity(uomDTO, findById(id));
			genericRepository.saveOrUpdate(uom);
		} else {
			UOM uom = mapUomDTOToEntity(uomDTO, null);
			id = (Long) genericRepository.save(uom);
		}
		return mapEntityToDTO(findById(id), UomDTO.class);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UomDTO findUomId(final Long id) {
		return mapEntityToDTO(findById(id), UomDTO.class);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		final UOM uom = findById(id);
		if (uom != null) {
			genericRepository.delete(uom);
		}

	}
	
	private UOM findById(final Long id) {
		return genericRepository.findById(UOM.class, id);
	}

	
}