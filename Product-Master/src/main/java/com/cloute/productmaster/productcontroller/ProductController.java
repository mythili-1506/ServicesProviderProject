package com.cloute.productmaster.productcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloute.productmaster.productenity.ProductMaster;
import com.cloute.productmaster.productservice.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/addproduct")
	public ResponseEntity<?>addProduct(@RequestBody ProductMaster productMast){
		
		return productService.addProduct(productMast);
	}
	
	
	@GetMapping("/getbyprductid/{productId}")
	public ResponseEntity<?>getByProductId(@PathVariable Long productId){
		
		return productService.getByProductId(productId);
	}
	
	@GetMapping("/getactiveprct")
	public ResponseEntity<?>getActiveProductDetails(){
		
		return productService.getActiveProductDetails();
	}
	
	@PostMapping("/deleteproduct/{productId}")
	public ResponseEntity<?>deleteProduct(@PathVariable Long productId){
		
		return productService.deleteProduct(productId);
	}
	
}
