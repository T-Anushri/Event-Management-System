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
public class BudgetDto {

	private Integer eventId;
	private String budgetId;
	private Integer totalBudget;
	private Integer allocatedAmount;
	private Integer actualSpending;
}

