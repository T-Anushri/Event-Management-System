package com.example.event_management.service;

import com.example.event_management.dto.AttendeeListDto;
import com.example.event_management.dto.BudgetDto;
import com.example.event_management.dto.EventDto;
import com.example.event_management.dto.ScheduleDto;
import com.example.event_management.dto.TaskListDto;
import com.example.event_management.dto.VendorListDto;
import com.example.event_management.dto.VenueDto;

public interface EventService {

	Integer saveEvent(EventDto dto);
	
	Integer saveAttendees(AttendeeListDto dto);

	Integer saveVendors(VendorListDto dto);
	
	Integer saveTasks(TaskListDto dto);

	Integer saveVenue(VenueDto dto);
	
	Integer saveSchedule(ScheduleDto dto);
	
	Integer saveBudget(BudgetDto dto);
	
	EventDto getEventInfo(String eventId);

}

