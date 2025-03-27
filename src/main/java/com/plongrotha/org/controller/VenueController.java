package com.plongrotha.org.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plongrotha.org.service.VenueService;

@RestController
@RequestMapping("api/v1/venue")
public class VenueController {

	private final VenueService venueService;

	public VenueController(VenueService venueService) {
         
		this.venueService = venueService;
	}

}
