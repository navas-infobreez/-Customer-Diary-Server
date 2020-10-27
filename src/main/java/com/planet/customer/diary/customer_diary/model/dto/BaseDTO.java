package com.planet.customer.diary.customer_diary.model.dto;

import org.springframework.data.annotation.Transient;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BaseDTO {

	@NonNull
	@JsonProperty("remoteId")
	private Long id;

	public BaseDTO(Long id) {
		super();
		this.id = id;
	}
	public BaseDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id <= 0) {
			this.id = null;
			return;
		}
		this.id = id;
	}
	
	@Transient
	public boolean isEmpty() {
		return getId() == null || getId() < 1;
	}
}
