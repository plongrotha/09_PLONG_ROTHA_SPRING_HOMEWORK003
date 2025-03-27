package com.plongrotha.org.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plongrotha.org.model.entity.Event;
import com.plongrotha.org.model.request.EventRequest;
import com.plongrotha.org.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	
	@Override
	public List<Event> getAllEvents(Integer page, Integer size) {
		return null;
	}

	@Override
	public Event getEventById(Long Id) {

		return null;
	}

	@Override
	public Event updateEventById(Long Id, EventRequest eventRequest) {

		return null;
	}

	@Override
	public Event createEvent(EventRequest eventRequest) {

		return null;
	}

	@Override
	public Event deleteEventById(Long Id) {

		return null;
	}

}
