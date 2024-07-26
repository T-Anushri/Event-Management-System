package com.example.event_management.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {

	private Integer id;
	private String eventId;
	private String eventName;
	private LocalDate eventDate;
	private String eventType;
	private String eventLocation;
	private String description;
	
	private VenueDto venue;
	private ScheduleDto schedule;
	private BudgetDto budget;
	private List<AttendeeDto> attendees;
	private List<VendorDto> vendors;
	private List<TaskDto> tasks;
}
