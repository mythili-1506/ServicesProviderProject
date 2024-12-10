package com.cloute.machineMaster.mechineService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloute.machineMaster.dtoclass.CustomerDto;
import com.cloute.machineMaster.dtoclass.MachineDetailsDto;
import com.cloute.machineMaster.dtoclass.ProductDto;
import com.cloute.machineMaster.exceptionhandling.CustomerFeignException;
import com.cloute.machineMaster.exceptionhandling.ProductFeignException;
import com.cloute.machineMaster.feignClients.CustomerDetailsFeign;
import com.cloute.machineMaster.feignClients.ProductDetailsFeign;
import com.cloute.machineMaster.mechineEntity.MachineMaster;
import com.cloute.machineMaster.mechineRepository.MachineRepository;

import feign.FeignException;

@Service
public class MachineService {
	
	@Autowired 
	MachineRepository machineRepo;
	
	@Autowired
	CustomerDetailsFeign customerFeign;
	
	@Autowired
	ProductDetailsFeign productFeign;
	
	
	
	private ProductDto productFeignConnect(long productId) {
		
		ProductDto productDto ;
		
		try {
			productDto = productFeign.getByProductId(productId).getBody();
		} catch (FeignException e) {
			throw new ProductFeignException(e.status(), "Product Not Found");
		}
		return productDto;
	}
	
	
	
	private CustomerDto customerFeignConnect(long custID) {
		
		CustomerDto customerDto;
		
		try {
			customerDto = customerFeign.getCustByID(custID).getBody();
		} catch (FeignException e) {
			throw new CustomerFeignException(e.status(),"customer not found");
		}
		return customerDto;
	}
	
	
	public ResponseEntity<?>addMachineDetails(MachineMaster mech)
	{	
		
		mech.setStatus(200);
		machineRepo.save(mech);
		
		return ResponseEntity.ok("created");
	}
	
	
	public ResponseEntity<?> getByMachineId(Long machineId) {
		
		Optional<MachineMaster> mech = machineRepo.findById(machineId);
		
		if(mech.isEmpty())
		{
			throw new RuntimeException("No machine in this id");
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
		
		Optional<MachineMaster>machineOpti = machineRepo.findById(machineId);
		if (machineOpti.isEmpty()) {
			return new ResponseEntity<>("There is no product in this id",HttpStatus.NOT_FOUND);
		}
		
		MachineMaster machine = machineOpti.get();
		
		ProductDto product = productFeignConnect(machine.getProductId());
				
		CustomerDto customer = customerFeignConnect(machine.getCustID());
		
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
