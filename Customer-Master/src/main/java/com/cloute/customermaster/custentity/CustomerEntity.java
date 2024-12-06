package com.cloute.customermaster.custentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	
	private String custCode;
	
	private String custName;
	
	private String custAdd1;
	
	private String custAdd2;
	
	private String custCity;
	
	private String custState;
	
	private long custPincode;
	
	private long custPhonenum;
	
	private String custEmail;
	
	private int custStatus; // 200 Active 404 Delete
}
