package com.cloute.machineMaster.dtoclass;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MachineDetailsDto {
	
	
	private Long machineId;
	
	private String machSearialNo; 
	
	private Date dateOfIntallation; //admin want to be enter the date

	private Timestamp warrantyStartDate;
	
	private Timestamp warrantyEndDate;
	
	private Timestamp amcStartDate;
	
	private Timestamp amcEndDate;
	
	private int status; //active = 200 delete = 404
	
	private String statusStr;
	
	private ProductDto productDetails;
	
	private CustomerDto customerDetails;
	
	
	
}
