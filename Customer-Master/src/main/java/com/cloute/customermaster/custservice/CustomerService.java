package com.cloute.customermaster.custservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cloute.customermaster.custentity.CustomerEntity;
import com.cloute.customermaster.custrepo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo custRepo;
	
	public ResponseEntity<?>addCustDetails(CustomerEntity custEntity)
	{
		custEntity.setCustStatus(200);
		
		custRepo.save(custEntity);
		
		return ResponseEntity.ok("Created");
	}

	public ResponseEntity<?> getCustById(Long custId) {
		
		Optional<CustomerEntity> custEnti = custRepo.findById(custId);
		
		if(custEnti.isEmpty())
		{
			return new ResponseEntity<>("There is no contant",HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(custEnti);
	}

	public ResponseEntity<?> getAllActiveCust() {
		List<CustomerEntity> custEnti = custRepo.findByCustStatus(200);
		if(custEnti.isEmpty())
		{
			return new ResponseEntity<>("No active Customers",HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(custEnti);
	}

	
	public ResponseEntity<?> deleteCustDetails(Long custId) {
		Optional<CustomerEntity>custEntity = custRepo.findById(custId);
		if(custEntity.isEmpty())
		{
			return new ResponseEntity<>("No Details",HttpStatus.NO_CONTENT);
		}
		
		CustomerEntity cust = custEntity.get();
		cust.setCustStatus(404);
		custRepo.save(cust);
		return ResponseEntity.ok("Deleted");
	}
	
}
