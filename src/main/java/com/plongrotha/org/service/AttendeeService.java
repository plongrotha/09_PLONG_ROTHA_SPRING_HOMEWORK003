package com.plongrotha.org.service;

import java.util.List;

import com.plongrotha.org.model.entity.Attendee;
import com.plongrotha.org.model.request.AttendeeRequest;

public interface AttendeeService {

	List<Attendee> getAllAttendees(Integer offset, Integer size);

	Attendee getAttendeeById(Long Id);

	Attendee updateAttendeeById(Long Id, AttendeeRequest attendeeRequest);

	Attendee createAttendee(AttendeeRequest attendeeRequest);

	Attendee deleteAttendeeById(Long Id);

}
