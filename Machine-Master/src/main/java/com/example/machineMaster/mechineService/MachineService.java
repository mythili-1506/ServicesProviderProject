package com.example.machineMaster.mechineService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.machineMaster.mechineEntity.MachineMaster;
import com.example.machineMaster.mechineRepository.MachineRepository;

@Service
public class MachineService {
	
	@Autowired 
	
	MachineRepository machineRepo;
	
	public ResponseEntity<?>addMachineDetails(MachineMaster mech)
	{	
		mech.setWarrantyStartDate(new Timestamp(System.currentTimeMillis()));
		mech.setAmcStartDate(new Timestamp(System.currentTimeMillis()));
		mech.setStatus(200);
		
		machineRepo.save(mech);
		
		return ResponseEntity.ok("created");
	}
	
	public ResponseEntity<?> getByCustID(long custID) {
		
		Optional<MachineMaster> mech = machineRepo.findByCustID(custID);
		
		if(mech.isEmpty())
		{
			return new ResponseEntity<>("No machine in this id ",HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(mech);
	}
	
	public ResponseEntity<?> getAllmachine() {
		
		List<MachineMaster> machList = machineRepo.findByStatus(200);
		if(machList.isEmpty())
		{
			return new ResponseEntity<>("there is no active machine details",HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(machList);
	}

	public ResponseEntity<?> deleteMachine(long custID) {
		Optional<MachineMaster> machOpti = machineRepo.findByCustID(custID);
		if (machOpti.isEmpty()) {
			return new ResponseEntity<>("No details in this id",HttpStatus.NOT_FOUND);
		}
		
		MachineMaster mech  = machOpti.get();
		
		mech.setStatus(404);
		
		return ResponseEntity.ok("Deleted");
	}
	
}
