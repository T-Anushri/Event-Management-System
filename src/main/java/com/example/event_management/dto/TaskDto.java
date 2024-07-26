package com.example.event_management.dto;

import java.time.LocalDate;

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
public class TaskDto {

	private String taskId;
	
	private String name;

	private String description;
	
	private LocalDate dueDate;
	
	private String assignedTo;
	
	private String status;
}

