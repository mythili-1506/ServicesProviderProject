package com.cloute.employeemaster.empcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloute.employeemaster.empentity.Employee;
import com.cloute.employeemaster.empservice.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeService empservice;
	
	@PostMapping("/addemployee")
	public ResponseEntity<?> addMachineDetails(@RequestBody Employee emp) {
		return empservice.addEmployeeDetails(emp);
	}
	
	
	@GetMapping("/getempid/{employeeId}")
	public ResponseEntity<?> getByEmployeeID(@PathVariable Long employeeId) {
		return empservice.getByEmployeeID(employeeId);
	}
	
	
	@GetMapping("/getallemp")
	public ResponseEntity<?> getAllEmployee() {
		return empservice.getAllEmployee();
	}
	
	
	@PostMapping("/deleteemp/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
		return empservice.deleteEmployee(employeeId);
	}
}
