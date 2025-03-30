package com.plongrotha.org.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plongrotha.org.exception.NotFoundException;
import com.plongrotha.org.model.entity.Event;
import com.plongrotha.org.model.request.EventRequest;
import com.plongrotha.org.repository.EventAttendeeRepository;
import com.plongrotha.org.repository.EventRepository;
import com.plongrotha.org.service.AttendeeService;
import com.plongrotha.org.service.EventService;
import com.plongrotha.org.service.VenueService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

	private final EventRepository eventRepository;
	private final EventAttendeeRepository eventAttendeeRepository;
	private final AttendeeService attendeeService;
	private final VenueService venueService;

	// public EventServiceImpl(EventRepository eventRepository,  EventAttendeeRepository eventAttendeeRepositor, 
	// 		AttendeeService attendeeService, VenueService venueService) {
	// 	this.eventRepository = eventRepository;
	// 	this.eventAttendeeRepository = eventAttendeeRepository;
	// 	this.attendeeService = attendeeService;
	// 	this.venueService = venueService;
	// }
	
	@Override
	public List<Event> getAllEvents(Integer offset, Integer size) {
		offset = (offset - 1) * size;
		return eventRepository.getAllEvents(offset, size);
	}

	@Override
	public Event getEventById(Long Id) {
		Event isEvent = eventRepository.getEventById(Id);
		if(isEvent ==  null) {
			throw new NotFoundException(" student with id : " + Id + " is not found");
		}
		return eventRepository.getEventById(Id);
	}

	@Override
	public Event updateEventById(Long Id, EventRequest eventRequest) {
		getEventById(Id);
		return eventRepository.updateEventById(Id, eventRequest);
	}

	@Override
	public Event createEvent(EventRequest eventRequest) {
		Event event = eventRepository.createEvent(eventRequest);
		for (Long attendeeId : eventRequest.getAttendeeIds()) {
			attendeeService.getAttendeeById(attendeeId);
			eventAttendeeRepository.createEventAttendee(event.getEventId(), attendeeId);
		}
		return eventRepository.getEventById(event.getEventId());
	}

	@Override
	public void deleteEventById(Long Id) {
		getEventById(Id);
		eventRepository.deleteEventById(Id);
	}

}
