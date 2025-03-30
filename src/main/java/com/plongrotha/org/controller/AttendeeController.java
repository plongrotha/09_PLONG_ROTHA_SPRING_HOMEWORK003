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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plongrotha.org.model.entity.Attendee;
import com.plongrotha.org.model.request.AttendeeRequest;
import com.plongrotha.org.model.response.ApiResponse;
import com.plongrotha.org.service.AttendeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {

	private final AttendeeService attendeeService;

	public AttendeeController(AttendeeService attendeeService) {
		this.attendeeService = attendeeService;
	}

	@Operation(summary = "Get all attendees")
	@GetMapping
	public ResponseEntity<?> getAllAttendees(@RequestParam(defaultValue = "1") Integer offset,@RequestParam(defaultValue = "10") Integer size) {
			List<Attendee> listAttendees = attendeeService.getAllAttendees(offset, size);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Get all attendees successfully")
				.payload(listAttendees)
				.timestemp(LocalDate.now())
				.build());
	}


	@Operation(summary = "Get attendee by id")
	@GetMapping("{attendee-id}")
	public ResponseEntity<?> getAttendeeById(@PathVariable("attendee-id") Long Id) {
		Attendee attendee = attendeeService.getAttendeeById(Id);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Get attendee successfully")
				.payload(attendee)
				.timestemp(LocalDate.now())
				.build());
	}


	@Operation(summary = "update attendee by id")
	@PutMapping("{attendee-id}")
	public ResponseEntity<?> updateAttendeeById(@PathVariable("attendee-id") Long Id, @RequestBody AttendeeRequest attendeeRequest) {
		Attendee updatedAttendee = attendeeService.updateAttendeeById(Id, attendeeRequest);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Update attendee successfully")
				.payload(updatedAttendee)
				.timestemp(LocalDate.now())
				.build());
	}


	@Operation(summary = "Create a attendee")
	@PostMapping
	public ResponseEntity<?> createAttendee(@RequestBody AttendeeRequest attendeeRequest) {
		Attendee createdAttendee = attendeeService.createAttendee(attendeeRequest);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.CREATED)
				.message("Create attendee successfully")
				.payload(createdAttendee)
				.timestemp(LocalDate.now())
				.build());
	}

	@Operation(summary = "Delete a attendee by id")
	@DeleteMapping("{attendee-id}")
	public ResponseEntity<?> deleteAttendeeById(@PathVariable("attendee-id") Long Id) {
		Attendee deletedAttendee = attendeeService.deleteAttendeeById(Id);
		return ResponseEntity.ok(ApiResponse.builder()
				.httpStatus(HttpStatus.OK)
				.message("Delete attendee successfully")
				.payload(deletedAttendee)
				.timestemp(LocalDate.now())
				.build());
	}


	


}
