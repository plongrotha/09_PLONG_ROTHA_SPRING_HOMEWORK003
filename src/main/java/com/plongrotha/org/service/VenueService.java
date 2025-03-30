package com.plongrotha.org.service;

import java.util.List;

import com.plongrotha.org.model.entity.Venue;
import com.plongrotha.org.model.request.VenueRequest;

public interface VenueService {

	List<Venue> getAllVenues(Integer offset, int size);

	Venue getVenueById(Long Id);

	Venue updateVenueById(Long Id, VenueRequest venueRequest);

	Venue createVenue(VenueRequest venueRequest);

	Venue deleteVenueById(Long Id);
}
