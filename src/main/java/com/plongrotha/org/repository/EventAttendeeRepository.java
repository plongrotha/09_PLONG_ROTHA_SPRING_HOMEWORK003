package com.plongrotha.org.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.plongrotha.org.model.entity.Attendee;

@Mapper
public interface EventAttendeeRepository {

    @Results(id = "eventAttendeeMapper", value = {
        @Result(property = "AttendeeId", column = "attendee_id"),
        @Result(property = "AttendeeName", column = "attendee_name"),
    })
    @Select("""
            SELECT * FROM event_attendees ea INNER JOIN attendees a ON ea.attendee_id = a.attendee_id
            WHERE event_id = #{eventId}
           
            """)
    List<Attendee> getAttendeesByEventId(Long eventId);

    // select * from event_attendees ea inner join attendees a on ea.attendee_id = a.attendee_id where event_id = #{eventId};

    @ResultMap("eventAttendeeMapper")
    @Select("""
           DELETE FROM event_attendees WHERE event_id = #{eventId}
            """)	
    void deleteAttendeeByEventId(Long eventId);


    @ResultMap("eventAttendeeMapper")
    @Select("""
            INSERT INTO event_attendees (event_id, attendee_id) VALUES (#{eventId}, #{attendeeId})
            """)
    void createEventAttendee(Long eventId, Long attendeeId);
}
