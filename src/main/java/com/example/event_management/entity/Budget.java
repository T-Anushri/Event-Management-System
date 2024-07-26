package com.example.event_management.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "budget_id", unique = true)
	private String budgetId;
	
	@Column(name = "total_budget")
	private Integer totalBudget;
	
	@Column(name = "allocated_amount")
	private Integer allocatedAmount;
	
	@Column(name = "actual_spending")
	private Integer actualSpending;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Event event;
}