package com.plongrotha.org.model.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

	private Long eventId;
	private String eventName;
	private LocalDate eventDate;
	private Venue venueId;
	private List<Attendee> attendees;
 }
