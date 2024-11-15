package com.example.machineMaster.mechineController;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.machineMaster.mechineEntity.MachineMaster;
import com.example.machineMaster.mechineService.MachineService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/machine")
public class MachineController {
	
	@Autowired
	
	MachineService machineService;
	
	@PostMapping("/addmachine")
	public ResponseEntity<?> addMachineDetails(@RequestBody MachineMaster mech) {
		
		return machineService.addMachineDetails(mech);
	}
	
	@GetMapping("/getcustbyid/{custID}")
	public ResponseEntity<?> getByCustID(@PathVariable long custID)
	{
		return machineService.getByCustID(custID);	
	}
	
	@GetMapping("/getallmachine")
	public ResponseEntity<?> getAllmachine()
	{
		return machineService.getAllmachine();
	}
	
	
	@PostMapping("/deleteMachine/{custID}")
	private ResponseEntity<?> deleteMachine(@PathVariable long custID) {
		return machineService.deleteMachine(custID);
	}
}
