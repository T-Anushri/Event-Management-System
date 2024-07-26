package com.example.event_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendeeDto {

	private String attendeeId;
	
	private String name;
	
	private String email;
	
	private String phoneNo;
	
	private String attendeeStatus;
}

