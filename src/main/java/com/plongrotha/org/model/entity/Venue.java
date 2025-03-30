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

	// public Venue() {
	// }

	// public Venue(Long venueId, String venueName, String venueLocation) {
	// 	super();
	// 	this.venueId = venueId;
	// 	this.venueName = venueName;
	// 	this.venueLocation = venueLocation;
	// }

	// public Long getVenueId() {
	// 	return venueId;
	// }

	// public void setVenueId(Long venueId) {
	// 	this.venueId = venueId;
	// }

	// public String getVenueName() {
	// 	return venueName;
	// }

	// public void setVenueName(String venueName) {
	// 	this.venueName = venueName;
	// }

	// public String getVenueLocation() {
	// 	return venueLocation;
	// }

	// public void setVenueLocation(String venueLocation) {
	// 	this.venueLocation = venueLocation;
	// }

}
