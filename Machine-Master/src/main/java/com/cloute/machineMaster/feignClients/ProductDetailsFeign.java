package com.cloute.machineMaster.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloute.machineMaster.dtoclass.ProductDto;

@FeignClient("PRODUCT-MASTER")
public interface ProductDetailsFeign {
	
	@GetMapping("/product/getbyprductid/{productId}")
	public ResponseEntity<ProductDto>getByProductId(@PathVariable Long productId);
	
}
