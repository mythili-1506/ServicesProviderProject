package com.cloute.employeemaster.empcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloute.employeemaster.empentity.Employee;
import com.cloute.employeemaster.empservice.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeService empservice;
	
	@PostMapping("/addemployee")
	public ResponseEntity<?> addMachineDetails(Employee emp) {
		return empservice.addEmployeeDetails(emp);
	}
	
	
	@GetMapping("/getempid/{employeeId}")
	public ResponseEntity<?> getByEmployeeID(long employeeId) {
		return empservice.getByEmployeeID(employeeId);
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEmployee() {
		return empservice.getAllEmployee();
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteEmployee(long employeeId) {
		return empservice.deleteEmployee(employeeId);
	}
}
