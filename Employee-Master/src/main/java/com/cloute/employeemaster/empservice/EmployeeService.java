package com.cloute.employeemaster.empservice;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloute.employeemaster.empentity.Employee;
import com.cloute.employeemaster.emprepository.EmpRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmpRepository  empRepo;
 
	public ResponseEntity<?> addEmployeeDetails(Employee employee) {
		
		employee.setEmpStatus(200);
		employee.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		
		empRepo.save(employee);
		return ResponseEntity.ok("created");
	}
	
	
public ResponseEntity<?> getByEmployeeID(long employeeId) {
		
		Optional<Employee> emp = empRepo.findByEmployeeId(employeeId);
		
		if(emp.isEmpty())
		{
			return new ResponseEntity<>("No employee in this id ",HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(emp);
	}


public ResponseEntity<?> getAllEmployee() {
	
	List<Employee> empList = empRepo.findByEmpStatus(200);
	if(empList.isEmpty())
	{
		return new ResponseEntity<>("there is no active machine details",HttpStatus.NOT_FOUND);
	}
	
	return ResponseEntity.ok(empList);
	}


public ResponseEntity<?> deleteEmployee(long employeeId) {
	Optional<Employee> empOpti = empRepo.findByEmployeeId(employeeId);
	if (empOpti.isEmpty()) {
		return new ResponseEntity<>("No details in this id",HttpStatus.NOT_FOUND);
	}
	
	Employee emp  = empOpti.get();
	
	emp.setEmpStatus(404);
	
	return ResponseEntity.ok("Deleted");
	
	}
}
