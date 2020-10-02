package com.planet.customer.diary.customer_diary.model.dto;

import org.springframework.lang.NonNull;


public class BaseDTO {

	@NonNull
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
		this.id = id;
	}
	

}
