package com.cloute.machineMaster.mechineEntity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MachineMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long machineId;
	
	private String machSearialNo; 
	
	private long custID;
	
	private long productId;
	
	private Date dateOfIntallation; //admin want to be enter the date
	
//	private long employeeId;
	
	private Timestamp warrantyStartDate;
	
	private Timestamp warrantyEndDate;
	
	private Timestamp amcStartDate;
	
	private Timestamp amcEndDate;
	
	private int status; //active = 200 delete = 404
	
}
