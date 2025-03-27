package com.plongrotha.org.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {

	private Long venueId;
	private String venueName;
	private String venueLocation;

}
