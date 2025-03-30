package com.plongrotha.org.controller;

import com.plongrotha.org.model.entity.Venue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plongrotha.org.service.VenueService;

import java.util.List;

@RestController
@RequestMapping("api/v1/venue")
public class VenueController {

	private final VenueService venueService;

	public VenueController(VenueService venueService) {
		this.venueService = venueService;
	}

	@GetMapping
	public List<Venue> getAllVenues() {




		return null;
	}

}
