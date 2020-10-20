package com.planet.customer.diary.customer_diary.service;

import java.util.List;

import com.planet.customer.diary.customer_diary.entity.UOM;
import com.planet.customer.diary.customer_diary.model.dto.UomDTO;

public interface UomService {

	public List<UomDTO> findAll();

	public UomDTO findUomId(Long id);

	public UomDTO createOrUpdateUom(UomDTO uomDTO);
	
	public UOM mapUomDTOToEntity(UomDTO uomDTO, UOM uom);

	public void delete(Long id);
	
}