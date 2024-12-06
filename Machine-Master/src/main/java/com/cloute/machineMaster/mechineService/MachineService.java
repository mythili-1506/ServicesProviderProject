package com.cloute.machineMaster.mechineService;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloute.machineMaster.dtoclass.CustomerDto;
import com.cloute.machineMaster.dtoclass.MachineDetailsDto;
import com.cloute.machineMaster.dtoclass.ProductDto;
import com.cloute.machineMaster.mechineEntity.MachineMaster;
import com.cloute.machineMaster.mechineRepository.MachineRepository;
import com.cloute.productmaster.feigncliend.CustomerDetailsFeign;
import com.cloute.productmaster.feigncliend.ProductDetailsFeign;

@Service
public class MachineService {
	
	@Autowired 
	MachineRepository machineRepo;
	
	@Autowired
	ProductDetailsFeign productFeign;
	
	@Autowired
	CustomerDetailsFeign customerFeign;
	
	
	public ResponseEntity<?>addMachineDetails(MachineMaster mech)
	{	
//		mech.setWarrantyStartDate(new Timestamp(System.currentTimeMillis()));
//		mech.setAmcStartDate(new Timestamp(System.currentTimeMillis()));
		mech.setStatus(200);
		machineRepo.save(mech);
		
		return ResponseEntity.ok("created");
	}
	
	
	public ResponseEntity<?> getByMachineId(Long machineId) {
		
		Optional<MachineMaster> mech = machineRepo.findById(machineId);
		
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

	
	public ResponseEntity<?> deleteMachine(Long machineId) {
		
		Optional<MachineMaster> machOpti = machineRepo.findById(machineId);
		
		if (machOpti.isEmpty()) {
			return new ResponseEntity<>("No details in this id",HttpStatus.NOT_FOUND);
		}
		
		MachineMaster mech  = machOpti.get();
		
		mech.setStatus(404);
		
		return ResponseEntity.ok("Deleted");
	}


	public ResponseEntity<?>fetchProductDetailsUsingProductId(long machineId) {
		
		Optional<MachineMaster>machineOpti = machineRepo.findByProductId(machineId);
		if (machineOpti.isEmpty()) {
			return new ResponseEntity<>("There is no product in this id",HttpStatus.NO_CONTENT);
		}
		
		MachineMaster machine = machineOpti.get();
		
		ProductDto product = productFeign.getByProductId(machine.getProductId()).getBody();
		
		CustomerDto customer = customerFeign.getCustByID(machine.getCustID()).getBody();
		
		MachineDetailsDto machineDetailsDto = MachineDetailsDto.builder()
				                              .amcEndDate(machine.getAmcEndDate())
				                              .amcStartDate(machine.getAmcStartDate())
				                              .dateOfIntallation(machine.getDateOfIntallation())
				                              .machSearialNo(machine.getMachSearialNo())
				                              .statusStr(machine.getStatus()==200 ? "Active ": "InActive")
				                              .warrantyEndDate(machine.getWarrantyEndDate())
				                              .warrantyStartDate(machine.getWarrantyStartDate())
				                              .customerDetails(customer)
		                                      .productDetails(product)
		                                      .build();
		return ResponseEntity.ok(machineDetailsDto);
	}
}
