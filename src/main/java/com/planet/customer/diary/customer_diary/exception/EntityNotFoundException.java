package com.planet.customer.diary.customer_diary.exception;

public class EntityNotFoundException extends RuntimeException {


	private static final long serialVersionUID = -1484299808343883622L;

	public EntityNotFoundException() {

	}

	public EntityNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
