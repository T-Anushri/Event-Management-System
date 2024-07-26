package com.example.event_management.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.event_management.dto.AttendeeDto;
import com.example.event_management.dto.AttendeeListDto;
import com.example.event_management.dto.BudgetDto;
import com.example.event_management.dto.EventDto;
import com.example.event_management.dto.ScheduleDto;
import com.example.event_management.dto.TaskDto;
import com.example.event_management.dto.TaskListDto;
import com.example.event_management.dto.VendorDto;
import com.example.event_management.dto.VendorListDto;
import com.example.event_management.dto.VenueDto;
import com.example.event_management.entity.Attendee;
import com.example.event_management.entity.Budget;
import com.example.event_management.entity.Event;
import com.example.event_management.entity.Schedule;
import com.example.event_management.entity.Task;
import com.example.event_management.entity.Vendor;
import com.example.event_management.entity.Venue;
import com.example.event_management.exception.EventException;
import com.example.event_management.repository.EventRepository;
import com.example.event_management.util.EventUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class EventServiceImpl implements EventService {

	private final EventRepository eventRepository;

	@Override
	public Integer saveEvent(EventDto dto) {
		log.info("EventServiceImpl :: saveEvent");

		Event event = EventUtil.dtoToEntity(dto);

		Event savedEvent = eventRepository.save(event);

		return savedEvent.getId();
	}

	@Override
	public Integer saveAttendees(AttendeeListDto dto) {
		log.info("EventServiceImpl :: saveAttendees");

		Optional<Event> primaryOptional = eventRepository.findById(dto.getEventId());

		if (primaryOptional.isPresent()) {
			Event event = primaryOptional.get();

			List<Attendee> attendees = EventUtil.dtoToEntities(dto);

			event.setAttendees(attendees);
			attendees.stream().forEach(att -> att.setEvent(event));

			return eventRepository.save(event).getId();

		}
		throw new EventException("Event Not Found");
	}
	
	@Override
	public Integer saveVendors(VendorListDto dto) {
		log.info("EventServiceImpl :: saveVendors");

		Optional<Event> primaryOptional = eventRepository.findById(dto.getEventId());

		if (primaryOptional.isPresent()) {
			Event event = primaryOptional.get();

			List<Vendor> vendors = EventUtil.dtoToEntities(dto);

			event.setVendors(vendors);
			vendors.stream().forEach(ven -> ven.setEvent(event));

			return eventRepository.save(event).getId();

		}
		throw new EventException("Event Not Found");
	}
	
	@Override
	public Integer saveTasks(TaskListDto dto) {
		log.info("EventServiceImpl :: saveTasks");

		Optional<Event> primaryOptional = eventRepository.findById(dto.getEventId());

		if (primaryOptional.isPresent()) {
			Event event = primaryOptional.get();

			List<Task> tasks = EventUtil.dtoToEntities(dto);

			event.setTasks(tasks);
			tasks.stream().forEach(task -> task.setEvent(event));

			return eventRepository.save(event).getId();

		}
		throw new EventException("Event Not Found");
	}

	@Override
	public Integer saveVenue(VenueDto dto) {
		log.info("EventServiceImpl :: saveVenue");

		Optional<Event> primaryOptional = eventRepository.findById(dto.getEventId());

		if (primaryOptional.isPresent()) {
			Event event = primaryOptional.get();

			Venue venue = EventUtil.dtoToEntiy(dto);

			event.setVenue(venue);
			venue.setEvent(event);

			return eventRepository.save(event).getId();
		}
		throw new EventException("Event Not Found");
	}	

	@Override
	public Integer saveSchedule(ScheduleDto dto) {
		log.info("EventServiceImpl :: saveSchedule");

		Optional<Event> primaryOptional = eventRepository.findById(dto.getEventId());

		if (primaryOptional.isPresent()) {

			Event event = primaryOptional.get();
			Schedule schedule = EventUtil.dtoToEntity(dto);

			event.setSchedule(schedule);
			schedule.setEvent(event);

			return eventRepository.save(event).getId();
		}
		throw new EventException("Employee Primary Info Not Found");
	}
	
	@Override
	public Integer saveBudget(BudgetDto dto) {
		log.info("EventServiceImpl :: saveBudget");

		Optional<Event> primaryOptional = eventRepository.findById(dto.getEventId());

		if (primaryOptional.isPresent()) {

			Event event = primaryOptional.get();
			Budget budget = EventUtil.dtoToEntity(dto);

			event.setBudget(budget);
			budget.setEvent(event);

			return eventRepository.save(event).getId();
		}
		throw new EventException("Employee Primary Info Not Found");
	}

	@Override
	public EventDto getEventInfo(String eventId) {
		Optional<Event> optionalInfo = eventRepository.findByEventId(eventId);
		if(optionalInfo.isPresent()) {
			Event info = optionalInfo.get();
		return EventDto.builder()
				.eventId(info.getEventId()).eventName(info.getEventName()).eventDate(info.getEventDate())

				.venue(VenueDto.builder()
						.venueId(info.getVenue().getVenueId()).venueName(info.getVenue().getVenueName())
						.address(info.getVenue().getAddress()).capacity(info.getVenue().getCapacity())
						.build())
				
				.schedule(ScheduleDto.builder().scheduleId(info.getSchedule().getScheduleId()).startTime(info.getSchedule().getStartTime())
						.endTime(info.getSchedule().getEndTime()).build())
				
				.budget(BudgetDto.builder().budgetId(info.getBudget().getBudgetId()).totalBudget(info.getBudget().getTotalBudget())
						.allocatedAmount(info.getBudget().getAllocatedAmount()).actualSpending(info.getBudget().getActualSpending()).build())
				
				.attendees(info.getAttendees().stream().map(att -> AttendeeDto.builder()
						.attendeeId(att.getAttendeeId()).name(att.getName())
						.email(att.getEmail()).phoneNo(att.getPhoneNo()).attendeeStatus(att.getAttendeeStatus()).build())
					.collect(Collectors.toList()))
				
				.vendors(info.getVendors().stream().map(ven -> VendorDto.builder()
						.vendorId(ven.getVendorId()).name(ven.getName()).
						email(ven.getEmail()).phoneNo(ven.getPhoneNo()).build())
					.collect(Collectors.toList()))
				
				.tasks(info.getTasks().stream().map(task -> TaskDto.builder()
						.taskId(task.getTaskId()).name(task.getName())
						.description(task.getDescription()).dueDate(task.getDueDate())
						.assignedTo(task.getAssignedTo()).status(task.getStatus()).build())
					.collect(Collectors.toList()))

				.build();

	}
	throw new EventException("Event Info Not Found");
	}
}