package com.plongrotha.org.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plongrotha.org.service.EventService;

@RestController
@RequestMapping("api/v1/eventss")
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {

		this.eventService = eventService;

	}

}
