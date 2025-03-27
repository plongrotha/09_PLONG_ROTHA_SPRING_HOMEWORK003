package com.plongrotha.org.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
	
	private String AttendeeName;
	private String AttendeeEmail;

}
