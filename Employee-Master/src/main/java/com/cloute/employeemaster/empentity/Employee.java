package com.cloute.employeemaster.empentity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

	
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "EmployeeMaster")
public class Employee {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long employeeId;  // employeeId
		
//		@Column(name = "empId", length = 30)
		private String employeeCode;  //code
		
//		@Column(name = "empFirstname",length = 20)
		private String empFirstName;
		
//		@Column(name = "empLastname",length = 10)
		private String empLastName;
		
//		@Column(name = "empPhone",length = 15)
		private String empPhone;
		
//		@Column(name = "empGender", length = 10)
		private String empGender;
		
//		@Column(name = "empDob", length = 20, columnDefinition = "DATE")
		private String empDateofBirth;
		
//		@Column(name = "JoiningDate", columnDefinition = "DATE")
		private String empJoiningDate;
		
//		@Column(name = "empAdd1",length = 80)
		private String addressLine1;
		
//		@Column(name = "empAdd2", length = 80)
		private String addressLine2;
		
//		@Column(name = "empState", length = 15)
		private String state;
		
//		@Column(name = "empCity", length = 20)
		private String city;
		
//		@Column(name = "empPin", length = 10)
		private String pin;	
		
//		@Column(name = "empCountry",length = 20)
		private String country;
		
		private int assignedArea;
		
//		@Column(length = 5,nullable = false)
		private int empStatus;
		
//		@Column(length = 100)
		private String empEmail;
		
//		@Column(length = 10)
		private String modifyby;
		
		private Timestamp modifiedTime;
		
	}
	


