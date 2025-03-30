package com.plongrotha.org.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.plongrotha.org.model.entity.Venue;
import com.plongrotha.org.model.request.VenueRequest;

@Mapper
public interface VenueRepository {

	@Results(id = "venueMapper", value = {
		 @Result(property = "venueId", column = "venue_id"),
		@Result(property = "venueName", column = "venue_name"),
		@Result(property = "venueLocation", column = "location")
	})
	@Select("""
			    select * from venues OFFSET #{offset} limit #{size};
			""")
	List<Venue> getAllVenue(Integer offset, Integer size);

	@ResultMap("venueMapper")
	@Select("""
			SELECT * FROM venues WHERE venue_id = #{id};
			""")
	Venue getVenueById(Long id);
	
	@ResultMap("venueMapper")
	@Select("""
			INSERT INTO venues (venue_name, location) VALUES (#{req.venueName}, #{req.venueLocation}) returning *;
			""")
	Venue createVenue(@Param("req") VenueRequest venueRequest);

	@ResultMap("venueMapper")
	@Select("""
			UPDATE venues SET venue_name = #{req.venueName}, location = #{req.venueLocation} WHERE venue_id = #{id} returning *;
			""")
	Venue updateVenueById(@Param("id") Long id, @Param("req") VenueRequest venueRequest);


	@ResultMap("venueMapper")
	@Select("""
			DELETE FROM venues WHERE venue_id = #{id} returning *;
			""")
	void deleteVenueById(Long id);

}
