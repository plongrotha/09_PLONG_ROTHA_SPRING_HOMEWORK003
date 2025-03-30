package com.plongrotha.org.model.response;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// my lombok not work
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
	private String message;
	private T payload;
	private HttpStatus httpStatus;
	private LocalDate timestemp;
//
//	public ApiResponse(String message, T payload, HttpStatus httpStatus, LocalDate timestemp) {
//		super();
//		this.message = message;
//		this.payload = payload;
//		this.httpStatus = httpStatus;
//		this.timestemp = timestemp;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public T getPayload() {
//		return payload;
//	}
//
//	public void setPayload(T payload) {
//		this.payload = payload;
//	}
//
//	public HttpStatus getHttpStatus() {
//		return httpStatus;
//	}
//
//	public void setHttpStatus(HttpStatus httpStatus) {
//		this.httpStatus = httpStatus;
//	}
//
//	public LocalDate getTimestemp() {
//		return timestemp;
//	}
//
//	public void setTimestemp(LocalDate timestemp) {
//		this.timestemp = timestemp;
//	}

}
