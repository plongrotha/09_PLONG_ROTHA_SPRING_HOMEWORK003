package com.plongrotha.org.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {

	private Long AttendeeId;
	private String AttendeeName;
	private String AttendeeEmail;

}
