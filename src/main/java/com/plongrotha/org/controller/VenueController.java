package com.plongrotha.org.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.plongrotha.org.model.entity.Venue;
import com.plongrotha.org.model.request.VenueRequest;
import com.plongrotha.org.model.response.ApiResponse;
import com.plongrotha.org.model.response.ApiResponseVenue;
import com.plongrotha.org.service.VenueService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v1/venue")
public class VenueController {

	private final VenueService venueService;

	public VenueController(VenueService venueService) {
		this.venueService = venueService;
	}

	@Operation(summary = "Get all venues")
	@GetMapping
	public ResponseEntity<?> getAllVenues(@RequestParam(defaultValue = "1") Integer offset,@RequestParam(defaultValue = "10") Integer size) {
		List<Venue> listAllVenues = venueService.getAllVenues(offset, size);
		return ResponseEntity.ok(ApiResponse.builder()
		.httpStatus(HttpStatus.OK)
		.message("Get all venues")
		.payload(listAllVenues)
		.timestemp(LocalDate.now())
		.build());
	}

	@Operation(summary = "Create a venue")
	@PostMapping
	public ResponseEntity<?> createVenue(@RequestBody VenueRequest venueRequest) {
		Venue venue = venueService.createVenue(venueRequest);
		return ResponseEntity.ok(ApiResponseVenue.builder()
	   .message("Create a venue successfully")
		.payload(venue)
		.status("OK")
		.timestemp(LocalDateTime.now())
		.build());
	}


	@Operation(summary = "update a venue by id")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateVenueById(@RequestParam Long id, @RequestBody VenueRequest venueRequest) {
		Venue venue = venueService.updateVenueById(id, venueRequest);
		return ResponseEntity.ok(ApiResponseVenue.builder()
		.message("Update a venue successfully")
		.payload(venue)
		.status("OK")
		.timestemp(LocalDateTime.now())
		.build());
	}


	@Operation(summary = "delete a venue by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVenueById(@RequestParam Long id) {
		venueService.deleteVenueById(id);
		return ResponseEntity.ok(ApiResponse.builder()
		.httpStatus(HttpStatus.OK)
		.message("Delete a venue successfully")
		.timestemp(LocalDate.now())
		.build());
	}

	@Operation(summary = "Get a venue by id")
	@GetMapping("/{venue-id}")
	public ResponseEntity<?> getVenueById(@PathVariable("venue-id") Long id) {
		Venue venue = venueService.getVenueById(id);
		return ResponseEntity.ok(ApiResponseVenue.builder()
		.message("Get a venue by id successfully")
		.payload(venue)
		.status("OK")
		.timestemp(LocalDateTime.now())
		.build());
	}
}
