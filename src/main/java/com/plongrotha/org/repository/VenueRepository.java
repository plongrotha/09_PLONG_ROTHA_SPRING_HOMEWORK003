package com.plongrotha.org.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;

import com.plongrotha.org.model.entity.Venue;
import com.plongrotha.org.model.request.VenueRequest;

@Mapper
public interface VenueRepository {

	
	@Results(id = "venueMapper", value = {
			
	})
	List<Venue> getAllVenue(Integer offset, int size);


	Venue getVenueById(Long id);
	
	
	Venue createVenue(@Param("req") VenueRequest venueRequest);

}
