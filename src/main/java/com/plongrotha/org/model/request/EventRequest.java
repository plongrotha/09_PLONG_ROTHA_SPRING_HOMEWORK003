package com.plongrotha.org.model.request;

import java.time.LocalDate;
import java.util.List;

import com.plongrotha.org.model.entity.Venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

	private String eventName;
	private LocalDate eventDate;
	private Long venueId;
	List<Long> attendeeIds;
}
