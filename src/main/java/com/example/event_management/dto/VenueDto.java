package com.example.event_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueDto {

	private Integer eventId;
	private String venueId;
	private String venueName;
	private String address;
	private Integer capacity;
}

