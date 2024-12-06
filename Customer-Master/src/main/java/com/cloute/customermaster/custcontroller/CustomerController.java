package com.cloute.customermaster.custcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.cloute.customermaster.custentity.CustomerEntity;
import com.cloute.customermaster.custservice.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerEntity custEntity) {
		return custService.addCustDetails(custEntity);
	}
	
	@GetMapping("/getcustbyid/{custId}")
	public ResponseEntity<?>getCustByID(@PathVariable Long custId)
	{
		return custService.getCustById(custId);
	}
	
	
	@GetMapping("/getallactcust")
	public ResponseEntity<?>getAllActiveCust()
	{
		return custService.getAllActiveCust();
	}
	
	
	@PostMapping("/deletecust/{custId}")
	public ResponseEntity<?>deleteCustDetails(@PathVariable Long custId)
	{
		return custService.deleteCustDetails(custId);
	}
}
