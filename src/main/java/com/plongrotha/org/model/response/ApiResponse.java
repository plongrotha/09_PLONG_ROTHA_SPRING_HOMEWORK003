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

}
