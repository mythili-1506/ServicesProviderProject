package com.cloute.machineMaster.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloute.machineMaster.dtoclass.CustomerDto;

@FeignClient("CUSTOMER-MASTER")
public interface CustomerDetailsFeign {
	
	@GetMapping("/customer/getcustbyid/{custId}")
	public ResponseEntity<CustomerDto>getCustByID(@PathVariable Long custId);
}
