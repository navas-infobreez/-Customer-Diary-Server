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
import com.planet.customer.diary.customer_diary.model.dto.UserRoleDTO;
import com.planet.customer.diary.customer_diary.service.UserRoleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "userrole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@GetMapping(value = "getuserrole")
	public ResponseDTO<UserRoleDTO> getUserRole(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		final UserRoleDTO userRole = userRoleService.findByRoleId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the user details",
				userRole);
	}
	
	@GetMapping(value = "deleteuserrole")
	public ResponseDTO<UserRoleDTO> deleteUserRole(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		userRoleService.delete(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully deleted user details",
				null);
	}
		
	@GetMapping(value = "getalluserrole")
	public ResponseDTO<List<UserRoleDTO>> getAllUserRoleDetails() {
		final List<UserRoleDTO> usersRole = userRoleService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all user details",
				usersRole);
	}
	
	@PostMapping(value = "createorupdateuserrole")
	public ResponseDTO<UserRoleDTO> createOrUpdateUserRole(@RequestBody final UserRoleDTO userRoleDTO) {
		final UserRoleDTO userRole = userRoleService.createOrUpdateUserRole(userRoleDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the user details",
				userRole);
	}
	
	

}