package com.cloute.machineMaster.dtoclass;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
	
	private long custId;
	
	private String custCode;
	
	private String custName;
	
	private String custAdd1;
	
	private String custAdd2;
	
	private String custCity;
	
	private String custState;
	
	private long custPincode;
	
	private long custPhonenum;
	
	private String custEmail;
	
	private int custStatus;
}
