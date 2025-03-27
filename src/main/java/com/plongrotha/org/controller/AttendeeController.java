package com.plongrotha.org.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plongrotha.org.service.AttendeeService;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {

	private final AttendeeService attendeeService;

	public AttendeeController(AttendeeService attendeeService) {

		this.attendeeService = attendeeService;
	}

}
