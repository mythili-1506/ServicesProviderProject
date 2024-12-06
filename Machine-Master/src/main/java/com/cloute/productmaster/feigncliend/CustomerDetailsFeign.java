package com.cloute.productmaster.feigncliend;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloute.machineMaster.dtoclass.CustomerDto;

@FeignClient("CUSTOMERSERVICE")
public interface CustomerDetailsFeign {
	
	@GetMapping("/customer/getcustbyid/{custId}")
	public ResponseEntity<CustomerDto>getCustByID(@PathVariable Long custId);
}
