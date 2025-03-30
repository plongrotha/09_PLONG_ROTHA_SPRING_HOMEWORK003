package com.plongrotha.org.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plongrotha.org.model.entity.Event;
import com.plongrotha.org.model.request.EventRequest;
import com.plongrotha.org.model.response.ApiResponse;
import com.plongrotha.org.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@Operation(summary = "Get all events")
	@GetMapping
	public ResponseEntity<?> getAllEvents(@RequestParam(defaultValue = "1") Integer offset,
			@RequestParam(defaultValue = "10") Integer size) {
		List<Event> listEvent = eventService.getAllEvents(offset, size);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(org.springframework.http.HttpStatus.OK)
				.message("Get all events")
				.payload(listEvent)
				.timestemp(LocalDate.now())
				.build());
	}

	@Operation(summary = "Get event by id")
	@GetMapping("{event-id}")
	public ResponseEntity<?> getEventById(@PathVariable("event-id") Long Id) {
		Event event = eventService.getEventById(Id);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Get event by id successfully")
				.payload(event)
				.timestemp(LocalDate.now())
				.build());
	}
	

	@Operation(summary = "Create a event")
	@PostMapping
	public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
		Event createdEvent = eventService.createEvent(eventRequest);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.CREATED)
				.message("Create event successfully")
				.payload(createdEvent)
				.timestemp(LocalDate.now())
				.build());
	}

	@Operation(summary = "update a event by id")
	@PutMapping("event-id")
	public ResponseEntity<?> updateEventById(@PathVariable("event-id") Long Id,
			@RequestParam("event") EventRequest eventRequest) {
		Event updatedEvent = eventService.updateEventById(Id, eventRequest);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Update event successfully")
				.payload(updatedEvent)
				.timestemp(LocalDate.now())
				.build());
	}


	@Operation(summary = "delete a event by id")
	@DeleteMapping("{event-id}")
	public ResponseEntity<?> deleteEventById(@PathVariable("event-id") Long Id) {
		eventService.deleteEventById(Id);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Delete event successfully")
				.timestemp(LocalDate.now())
				.build());
	}
	

}
