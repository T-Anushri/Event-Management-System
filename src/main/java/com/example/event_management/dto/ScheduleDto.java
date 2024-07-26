package com.example.event_management.dto;

import java.time.LocalDateTime;

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
public class ScheduleDto {

	private Integer eventId;
	private String scheduleId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
}

