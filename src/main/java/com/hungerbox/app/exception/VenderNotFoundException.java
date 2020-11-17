package com.hungerbox.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VenderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VenderNotFoundException(String message) {
		super(message);
	}

	public VenderNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
