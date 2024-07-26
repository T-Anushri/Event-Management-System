package com.example.event_management.dto;

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
public class VendorDto {

	private String vendorId;
	
	private String name;
	
	private String email;
	
	private String phoneNo;
	
}

