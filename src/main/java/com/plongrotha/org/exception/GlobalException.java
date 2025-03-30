package com.plongrotha.org.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NotFoundException.class)
	public ProblemDetail notFoundExceptionhandler(NotFoundException e) {
		ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		detail.setProperty("timestemp", LocalDate.now());
		return detail;
	}

}
