package com.cloute.productmaster.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloute.productmaster.productenity.ProductMaster;
import com.cloute.productmaster.productrepository.ProductRepo;


@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	public ResponseEntity<?> addProduct(ProductMaster productMast) {
		
		productMast.setProductStatus(200);
		productRepo.save(productMast);
		
		return ResponseEntity.ok("Created");
	}

	public ResponseEntity<?> getByProductId(Long productId) {
		
		Optional<ProductMaster> product = productRepo.findById(productId);
		
		if(product.isEmpty()) {
			return new ResponseEntity<>("There is no poduct available in this productid",HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(product);

	}

	public ResponseEntity<?> getActiveProductDetails() {
		
		List<ProductMaster> product = productRepo.findByProductStatus(200);
		
		if(product.isEmpty()) {
			return new ResponseEntity<>("No Active ProductDetails",HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(product);
	}

	public ResponseEntity<?> deleteProduct(Long productId) {
		
		Optional<ProductMaster> productOpti = productRepo.findById(productId);
		
		if(productOpti.isEmpty()) {
			return new ResponseEntity<>("There is no details in this id",HttpStatus.NO_CONTENT);
		}
		
		ProductMaster product = productOpti.get();
		product.setProductStatus(400);
		productRepo.save(product);
		
		return ResponseEntity.ok("Deleted");
	}
	
}
