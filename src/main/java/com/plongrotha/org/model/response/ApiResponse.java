package com.plongrotha.org.model.response;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	private String message;
	private HttpStatus httpStatus;
	private T payload;
	private LocalDate timestemp;
}
