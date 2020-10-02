package com.planet.customer.diary.customer_diary.model.dto;

import java.util.Date;

public class ErrorDetailsDTO {
	private final Date timestamp;
	private final String message;
	private final String details;
	
	public ErrorDetailsDTO(final Date timestamp, final String message, final String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	

}