package com.example.event_management.controller;

import java.util.Arrays;

import static com.example.event_management.constant.EventConstants.EVENT_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.ATTENDEE_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.VENDOR_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.TASK_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.VENUE_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.SCHEDULE_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.BUDGET_SAVED_MESSAGE;
import static com.example.event_management.constant.EventConstants.EVENT_FETCH_MESSAGE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.example.event_management.response.CommonResponse;
import com.example.event_management.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v2")
@RequiredArgsConstructor
@Slf4j
public class EventController {

	private final EventService eventService;

	@GetMapping("/event")
	public EventDto getEvent() {
		return EventDto.builder().build();
	}	
	
	@GetMapping("/event/{eventId}")
	public ResponseEntity<CommonResponse<EventDto>> getEventInfo(@PathVariable String eventId) {
		log.info("EventController :: getEventInfo");
		EventDto eventInfo = eventService.getEventInfo(eventId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<EventDto>builder()
						.isError(false)
						.data(eventInfo)
						.message(EVENT_FETCH_MESSAGE)
					.build());
	}	
	@GetMapping("/attendee")
  public AttendeeListDto getAttendee() {
 	 return AttendeeListDto.builder().attendees(Arrays.asList(AttendeeDto.builder().build())).build();
  }

	@GetMapping("/vendor")
	public VendorListDto getVendor() {
		return VendorListDto.builder().vendors(Arrays.asList(VendorDto.builder().build())).build();
	}	
	
	@GetMapping("/task")
	public TaskListDto getAddress() {
		return TaskListDto.builder().tasks(Arrays.asList(TaskDto.builder().build())).build();
	}
	
	@GetMapping("/venue")
	public VenueDto getBankDetails() {
		return VenueDto.builder().build();
	}
	
	@GetMapping("/schedule")
	public ScheduleDto getTechnicalList() {
		return ScheduleDto.builder().build();
	}
	
	@GetMapping("/budget")
	public BudgetDto getExperience() {
		return BudgetDto.builder().build();
	}	

	@PostMapping("/event")
	public ResponseEntity<CommonResponse<Integer>> saveEvent(@RequestBody EventDto dto) {
		log.info("EventController :: saveEvent");
		Integer eventId = eventService.saveEvent(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(EVENT_SAVED_MESSAGE)
					.build());
	}
	
	@PutMapping("/attendee")
	public ResponseEntity<CommonResponse<Integer>> saveAttendees(@RequestBody AttendeeListDto dto){
		log.info("EventController :: saveAttendees");
		Integer eventId = eventService.saveAttendees(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(ATTENDEE_SAVED_MESSAGE)
					.build());
	}
	
	@PutMapping("/vendor")
	public ResponseEntity<CommonResponse<Integer>> saveAddresses(@RequestBody VendorListDto dto){
		log.info("EmployeeController :: saveVendors");
		Integer eventId = eventService.saveVendors(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(VENDOR_SAVED_MESSAGE)
					.build());
	}
	
	@PutMapping("/task")
	public ResponseEntity<CommonResponse<Integer>> saveAddresses(@RequestBody TaskListDto dto){
		log.info("EventController :: saveTasks");
		Integer eventId = eventService.saveTasks(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(TASK_SAVED_MESSAGE)
					.build());
	}
	
	@PutMapping("/venue")
	public ResponseEntity<CommonResponse<Integer>> saveVenue(@RequestBody VenueDto dto){
		log.info("EventController :: saveVenue");
		Integer eventId = eventService.saveVenue(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(VENUE_SAVED_MESSAGE)
						.build());
	}
	
	@PutMapping("/schedule")
	public ResponseEntity<CommonResponse<Integer>> saveSchedule(@RequestBody ScheduleDto dto){
		log.info("EventController :: saveSchedule");
		Integer eventId = eventService.saveSchedule(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(SCHEDULE_SAVED_MESSAGE)
						.build());
	}
	
	@PutMapping("/budget")
	public ResponseEntity<CommonResponse<Integer>> saveBudget(@RequestBody BudgetDto dto){
		log.info("EventController :: saveBudget");
		Integer eventId = eventService.saveBudget(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<Integer>builder()
						.isError(false)
						.data(eventId)
						.message(BUDGET_SAVED_MESSAGE)
						.build());
	}
}

