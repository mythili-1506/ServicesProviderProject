package com.example.machineMaster.mechineEntity;

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
	private Long custSno;
	
	private long custID;
	
	private String custAdd1;
	
	private String custAdd2;
	
	private String custCity;
	
	private long custPincode;
	
	private long machSno;
	
	private String assignEmployee;
	
	private String productName;
	
	private Timestamp warrantyStartDate;
	
	private Timestamp warrantyEndDate;
	
	private Timestamp amcStartDate;
	
	private Timestamp amcEndDate;
	
	private Date dateOfIntallation;
	
	private int status; //active = 200 delete = 404
	
}
