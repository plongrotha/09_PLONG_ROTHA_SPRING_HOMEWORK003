package com.plongrotha.org.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plongrotha.org.exception.NotFoundException;
import com.plongrotha.org.model.entity.Attendee;
import com.plongrotha.org.model.request.AttendeeRequest;
import com.plongrotha.org.repository.AttendeeRepository;
import com.plongrotha.org.service.AttendeeService;

@Service
public class AttendeeServiceImpl implements AttendeeService {

	private final AttendeeRepository attendeeRepository;

	public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
		this.attendeeRepository = attendeeRepository;
	}

	@Override
	public List<Attendee> getAllAttendees(Integer offset, Integer size) {
		offset = (offset - 1) * size;

		return attendeeRepository.getAllAttendees(offset, size);
	}

	@Override
	public Attendee getAttendeeById(Long Id) {
		Attendee attendee = attendeeRepository.getAttendeeById(Id);
		if (attendee == null) {
			throw new NotFoundException("Attendee not found with id : " + Id  );
		}
		return attendee;
	}

	@Override
	public Attendee updateAttendeeById(Long Id, AttendeeRequest attendeeRequest) {
	     getAttendeeById(Id);
		 return attendeeRepository.updateAttendeeById(Id, attendeeRequest);

	}

	@Override
	public Attendee createAttendee(AttendeeRequest attendeeRequest) {
		return attendeeRepository.createAttendee(attendeeRequest);
	}

	@Override
	public Attendee deleteAttendeeById(Long Id) {
		getAttendeeById(Id);
       return attendeeRepository.deleteAttendeeById(Id);
	}

}
