package com.planet.customer.diary.customer_diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.planet.customer.diary.customer_diary.model.dto.ResponseDTO;
import com.planet.customer.diary.customer_diary.model.dto.UomDTO;
import com.planet.customer.diary.customer_diary.service.UomService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "uom")
public class UomController {

	@Autowired
	private UomService uomService;

	@GetMapping(value = "getuom")
	public ResponseDTO<UomDTO> getUom(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		final UomDTO uom = uomService.findUomId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the Uom details",
				uom);
	}
	
	@GetMapping(value = "deleteuom")
	public ResponseDTO<UomDTO> deleteUom(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		uomService.delete(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully deleted Uom details",
				null);
	}
		
	@GetMapping(value = "getalluom")
	public ResponseDTO<List<UomDTO>> getAllUomDetails() {
		final List<UomDTO> uomList = uomService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all Uom details",
				uomList);
	}
	
	@PostMapping(value = "createorupdateuom")
	public ResponseDTO<UomDTO> createOrUpdateUom(@RequestBody final UomDTO uomDTO) {
		final UomDTO uom = uomService.createOrUpdateUom(uomDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the Uom details", uom);
	}
	
	

}