package com.plongrotha.org.service;

import java.util.List;

import com.plongrotha.org.model.entity.Event;
import com.plongrotha.org.model.request.EventRequest;

public interface EventService {

	List<Event> getAllEvents();

	Event getEventById(Long Id);

	Event updateEventById(Long Id, EventRequest eventRequest);

	Event createEvent(EventRequest eventRequest);

	Event deleteEventById(Long Id);

}
