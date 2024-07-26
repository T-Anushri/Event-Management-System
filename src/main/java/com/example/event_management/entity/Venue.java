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
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "venue_id", unique = true)
	private String venueId;
	
	@Column(name = "venue_name")
	private String venueName;
	
	@Column(name = "venue_address")
	private String address;
	
	@Column(name = "venue_capacity")
	private Integer capacity;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Event event;
}

