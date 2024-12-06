package com.cloute.machineMaster.mechineController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloute.machineMaster.mechineEntity.MachineMaster;
import com.cloute.machineMaster.mechineService.MachineService;


@Controller
@RequestMapping("/machine")
public class MachineController {
	
	@Autowired
	MachineService machineService;
	
	@PostMapping("/addmachine")
	public ResponseEntity<?> addMachineDetails(@RequestBody MachineMaster mech) {
		
		return machineService.addMachineDetails(mech);
	}
	
	@GetMapping("/getmachinebyid/{machineId}")
	public ResponseEntity<?> getByCustID(@PathVariable Long machineId){
		
		return machineService.getByMachineId(machineId);
	
	}
	
	@GetMapping("/getallmachine")
	public ResponseEntity<?> getAllmachine(){
		
		return machineService.getAllmachine();
	
	}
	
	
	@PostMapping("/deletemachine/{machineId}")
	private ResponseEntity<?> deleteMachine(@PathVariable Long machineId) {
		
		return machineService.deleteMachine(machineId);
	
	}
	
	
	private ResponseEntity<?>fetchProductDetailsUsingProductId(@PathVariable Long machineId){
		
		return machineService.fetchProductDetailsUsingProductId(machineId);
	}
	
}
