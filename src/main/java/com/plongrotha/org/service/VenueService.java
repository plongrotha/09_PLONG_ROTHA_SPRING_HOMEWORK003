package com.plongrotha.org.service;

import java.util.List;

import com.plongrotha.org.model.entity.Venue;
import com.plongrotha.org.model.request.VenueRequest;

public interface VenueService {

	List<Venue> getAllVenues(Integer offset, Integer size);

	Venue getVenueById(Long Id);

	Venue updateVenueById(Long Id, VenueRequest venueRequest);

	Venue createVenue(VenueRequest venueRequest);

	void deleteVenueById(Long Id);
}
