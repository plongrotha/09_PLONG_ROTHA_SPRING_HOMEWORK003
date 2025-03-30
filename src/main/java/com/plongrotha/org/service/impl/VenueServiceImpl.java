package com.plongrotha.org.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plongrotha.org.exception.NotFoundException;
import com.plongrotha.org.model.entity.Venue;
import com.plongrotha.org.model.request.VenueRequest;
import com.plongrotha.org.repository.VenueRepository;
import com.plongrotha.org.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	private final VenueRepository venueRepository;

	public VenueServiceImpl(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	@Override
	public List<Venue> getAllVenues(Integer offset, int size) {

		offset = (offset - 1) * size;

		return venueRepository.getAllVenue(offset, size);
	}

	@Override
	public Venue getVenueById(Long Id) {

		Venue isVenue = venueRepository.getVenueById(Id);

		if(isVenue ==  null) {
			throw new NotFoundException(" student with id : " + Id + " is not found.");
		}
		return isVenue;
	}

	@Override
	public Venue updateVenueById(Long Id, VenueRequest venueRequest) {

		return null;
	}

	@Override
	public Venue createVenue(VenueRequest venueRequest) {

		Venue isVenue = venueRepository.createVenue(venueRequest);
		
		return null;
	}

	@Override
	public Venue deleteVenueById(Long Id) {

		return null;
	}

}
