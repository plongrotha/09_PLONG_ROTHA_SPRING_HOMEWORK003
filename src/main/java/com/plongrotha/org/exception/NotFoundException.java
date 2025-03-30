package com.plongrotha.org.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message + "Not found");
	}
}
