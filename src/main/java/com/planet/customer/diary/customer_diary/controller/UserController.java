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
import com.planet.customer.diary.customer_diary.model.dto.UserDTO;
import com.planet.customer.diary.customer_diary.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "getuserdetails")
	public ResponseDTO<UserDTO> getUserDetails(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		final UserDTO user = userService.findByUserId(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the user details",
				user);
	}
	
	@PostMapping(value = "deleteuser")
	public ResponseDTO<UserDTO> deleteUser(@RequestParam String pid) {
		final Long id = Long.valueOf(pid);
		userService.delete(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully deleted user details",
				null);
	}
	
	@PostMapping(value = "getuserdetailsbyname")
	public ResponseDTO<UserDTO> getUserDetailsbyUserName(@RequestParam String userName) {
		final UserDTO user = userService.findByUserName(userName);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the user details",
				user);
	}
	
	@GetMapping(value = "getalluserdetails")
	public ResponseDTO<List<UserDTO>> getAllUserDetails(){
		final List<UserDTO> users = userService.findAll();
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully loaded the all user details",
				users);
	}
	
	@PostMapping(value = "createorupdateuser")
	public ResponseDTO<UserDTO> createOrUpdateUser(@RequestBody final UserDTO userDTO){
		final UserDTO user = userService.createOrUpdateUser(userDTO);
		return new ResponseDTO<>(HttpStatus.OK.value(), "Successfully updated the user details",
				user);
	}
	
	

}