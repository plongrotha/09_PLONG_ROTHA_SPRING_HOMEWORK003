package com.plongrotha.org.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.plongrotha.org.model.entity.Attendee;
import com.plongrotha.org.model.request.AttendeeRequest;

@Mapper
public interface AttendeeRepository {

    @Results(id = "attendeeMapper", value = {
            @Result(property = "AttendeeId", column = "attendee_id"),
            @Result(property = "AttendeeName", column = "attendee_name"),
            @Result(property = "AttendeeEmail", column = "email"),
    })
    @Select("""
        SELECT * FROM attendees OFFSET #{offset} LIMIT #{size} 
            """)
    List<Attendee> getAllAttendees(@Param("offset") Integer offset, @Param("size") Integer size);

    @ResultMap("attendeeMapper")
    @Select("""
        SELECT * FROM attendees WHERE attendee_id = #{Id}
    """)
    Attendee getAttendeeById(@Param("Id") Long Id);

    @ResultMap("attendeeMapper")
    @Select("""
        UPDATE attendees SET attendee_name = #{req.attendeeName}, email = #{req.AttendeeEmail} WHERE attendee_id = #{Id} RETURNING *;
    """)
    Attendee updateAttendeeById(@Param("Id") Long Id, @Param("req") AttendeeRequest attendeeRequest);

    @ResultMap("attendeeMapper")
    @Select("""
        INSERT INTO attendees (attendee_name, email) VALUES (#{req.attendeeName}, #{req.AttendeeEmail}) RETURNING *;
    """)
    Attendee createAttendee(@Param("req") AttendeeRequest attendeeRequest);

    @ResultMap("attendeeMapper")
    @Select("""
        DELETE FROM attendees WHERE attendee_id = #{Id}
    """)
    Attendee deleteAttendeeById(@Param("Id") Long Id);


}
