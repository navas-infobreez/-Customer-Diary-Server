package com.planet.customer.diary.customer_diary.exception;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(final ConversionNotSupportedException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return super.handleConversionNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return error(HttpStatus.BAD_REQUEST, ex, "Bad request");
	}

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<String> handleRunTimeException(final RuntimeException e) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
	}

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<String> handleEntityNotFoundExceptionException(final RuntimeException e) {
		return error(HttpStatus.NOT_FOUND, e);
	}

	private ResponseEntity<String> error(final HttpStatus status, final Exception e) {
		return ResponseEntity.status(status).body(e.getMessage());
	}

	private ResponseEntity<Object> error(final HttpStatus status, final Exception e, final String localMessage) {
		return ResponseEntity.status(status)
				.body("Message: " + localMessage + " , Exception Message: " + e.getMessage());
	}

}
