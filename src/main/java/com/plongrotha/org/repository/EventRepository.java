package com.plongrotha.org.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.plongrotha.org.model.entity.Event;
import com.plongrotha.org.model.request.EventRequest;

@Mapper
public interface EventRepository {

    @Results(id ="eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
               @Result(property = "eventName", column = "event_name"),
               @Result(property = "eventDate", column = "event_date"),
               @Result(property = "venue", column = "venue_id",
               one = @One(select = "com.plongrotha.org.repository.VenueRepository.getVenueById")),   
               @Result(property = "attendees", column = "event_id",
               many = @Many(
               select = "com.plongrotha.org.repository.EventAttendeeRepository.getAttendeesByEventId"))
    })
     @Select("""
        SELECT * FROM events OFFSET #{offset} LIMIT #{size}   
    """)
    List<Event> getAllEvents(Integer offset, Integer size);

    //
    @ResultMap("eventMapper")
    @Select("SELECT * FROM events WHERE event_id = #{Id}")
    Event getEventById(Long Id);

    //
    @ResultMap("eventMapper")
    @Select("""
       UPATE events
       SET event_name = #{req.eventName}, event_date = #{req.eventDate}, venue_id = #{req.venueId}
       WHERE event_id = #{Id}
    """)
    Event updateEventById(Long Id,@Param("req") EventRequest eventRequest);

    //
    @ResultMap("eventMapper")
    @Select("""
       INSERT INTO events (event_name, event_date, venue_id)
       VALUES (#{req.eventName}, #{req.eventDate}, #{req.venueId})
    """)
    Event createEvent(@Param("req") EventRequest eventRequest);

    //
    @ResultMap("eventMapper")
    @Select("DELETE FROM events WHERE event_id = #{Id}")
    void deleteEventById(Long Id);
}
