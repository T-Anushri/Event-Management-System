package com.example.event_management.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.event_management.dto.AttendeeListDto;
import com.example.event_management.dto.BudgetDto;
import com.example.event_management.dto.EventDto;
import com.example.event_management.dto.ScheduleDto;
import com.example.event_management.dto.TaskListDto;
import com.example.event_management.dto.VendorListDto;
import com.example.event_management.dto.VenueDto;
import com.example.event_management.entity.Attendee;
import com.example.event_management.entity.Budget;
import com.example.event_management.entity.Event;
import com.example.event_management.entity.Schedule;
import com.example.event_management.entity.Task;
import com.example.event_management.entity.Vendor;
import com.example.event_management.entity.Venue;


public class EventUtil {
	private EventUtil() {
	}

	public static Event dtoToEntity(EventDto dto) {
		return Event.builder().eventId(dto.getEventId()).eventName(dto.getEventName()).eventDate(dto.getEventDate())
				.eventType(dto.getEventType()).eventLocation(dto.getEventLocation()).description(dto.getDescription()).build();
	}
	
	public static List<Attendee> dtoToEntities(AttendeeListDto dto) {
		return dto.getAttendees().stream()
				.map(att -> Attendee.builder().attendeeId(att.getAttendeeId()).name(att.getName())
						.email(att.getEmail()).phoneNo(att.getPhoneNo()).attendeeStatus(att.getAttendeeStatus()).build())
				.collect(Collectors.toList());
	}

	public static List<Vendor> dtoToEntities(VendorListDto dto) {
		return dto.getVendors().stream()
				.map(ven -> Vendor.builder().vendorId(ven.getVendorId()).name(ven.getName()).
						email(ven.getEmail()).phoneNo(ven.getPhoneNo()).build())
				.collect(Collectors.toList());
	}
	
	public static List<Task> dtoToEntities(TaskListDto dto) {
		return dto.getTasks().stream()
				.map(task -> Task.builder().taskId(task.getTaskId()).name(task.getName())
						.description(task.getDescription()).dueDate(task.getDueDate())
						.assignedTo(task.getAssignedTo()).status(task.getStatus()).build())
				.collect(Collectors.toList());
	}
	
	public static Venue dtoToEntiy(VenueDto dto) {
		return Venue.builder().venueId(dto.getVenueId()).venueName(dto.getVenueName())
				.address(dto.getAddress()).capacity(dto.getCapacity()).build();
	}
	
	
	public static Schedule dtoToEntity(ScheduleDto dto) {
		return Schedule.builder().scheduleId(dto.getScheduleId()).startTime(dto.getStartTime())
				.endTime(dto.getEndTime()).build();
	}
	
	
	public static Budget dtoToEntity(BudgetDto dto) {
		return Budget.builder().budgetId(dto.getBudgetId()).totalBudget(dto.getTotalBudget())
				.allocatedAmount(dto.getAllocatedAmount()).actualSpending(dto.getActualSpending()).build();
	}

}

