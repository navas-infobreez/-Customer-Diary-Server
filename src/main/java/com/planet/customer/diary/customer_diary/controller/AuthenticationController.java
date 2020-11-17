package com.planet.customer.diary.customer_diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planet.customer.diary.customer_diary.domain.AuthToken;
import com.planet.customer.diary.customer_diary.domain.LoginUser;
import com.planet.customer.diary.customer_diary.model.dto.ResponseDTO;
import com.planet.customer.diary.customer_diary.model.dto.UserDTO;
import com.planet.customer.diary.customer_diary.service.UserService;
import com.planet.customer.diary.customer_diary.util.JwtTokenUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "login")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping(value = "generate-token")
	public ResponseDTO<AuthToken> register(@RequestBody final LoginUser loginUser) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

		final UserDTO user = userService.findByUserName(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return new ResponseDTO<>(200, "Success", new AuthToken(token, user));
	}

	@GetMapping(value = "/greeting")
	public String getGreeting() {
		return "Hello World!";
	}

}