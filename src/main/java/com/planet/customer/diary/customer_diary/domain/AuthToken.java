package com.planet.customer.diary.customer_diary.domain;

import com.planet.customer.diary.customer_diary.model.dto.UserDTO;

public class AuthToken {

	private String token;

	private UserDTO user;

	public AuthToken() {

	}

	public AuthToken(final String token, final UserDTO user) {
		this.token = token;
		this.user = user;
	}

	public AuthToken(final String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}