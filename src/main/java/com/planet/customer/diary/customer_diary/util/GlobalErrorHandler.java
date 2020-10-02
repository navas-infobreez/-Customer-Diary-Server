package com.planet.customer.diary.customer_diary.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.planet.customer.diary.customer_diary.model.dto.ErrorDetailsDTO;

/*-
 *
 * @author Arun Kumar S A
 *
 * Use appropriate status code based on the error.
 *
 * 404 - RESOURCE NOT FOUND
 * 400 - BAD REQUEST
 * 401 - UNAUTHORIZED
 * 415 - UNSUPPORTED TYPE - Representation not supported for the resource
 * 500 - SERVER ERROR
 */
@ControllerAdvice
@RestController
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<ErrorDetailsDTO> handleAuthenticationException(final AuthenticationException ex,
			final WebRequest request) {
		return new ResponseEntity<>(getErrorDetailsDTO(ex, request), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public final ResponseEntity<ErrorDetailsDTO> handleUserNotFoundException(final UsernameNotFoundException ex,
			final WebRequest request) {
		return new ResponseEntity<>(getErrorDetailsDTO(ex, request), HttpStatus.NOT_FOUND);
	}

	private ErrorDetailsDTO getErrorDetailsDTO(final RuntimeException ex, final WebRequest request) {
		return new ErrorDetailsDTO(new Date(), ex.getMessage(), request.getDescription(false));
	}

}