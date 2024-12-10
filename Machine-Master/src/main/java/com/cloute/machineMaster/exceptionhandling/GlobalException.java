package com.cloute.machineMaster.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ProductFeignException.class)
//	@ExceptionHandler(CustomerFeignException.class)
	public ResponseEntity<ErrorResponce>handleFeignException(ProductFeignException ex){
		
		ErrorResponce responce;
		
		if(ex.status()==404) {
			responce= ErrorResponce.builder()
			.error("Product not available")
			.errorCode(HttpStatus.NOT_FOUND)
			.build();
		}else if(ex.status()==503) {
			responce = ErrorResponce.builder()
					.error("Service not available")
					.errorCode(HttpStatus.SERVICE_UNAVAILABLE)
					.build();
		}else {
			responce = ErrorResponce.builder()
					.error("Internal server error")
					.errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
		
		return ResponseEntity.ok(responce);
	}
	
	
	@ExceptionHandler(CustomerFeignException.class)
	public ResponseEntity<ErrorResponce>handleCustomerFeignException(CustomerFeignException ex){
		
		ErrorResponce responce;
		
		if(ex.status()==400) {
			responce = ErrorResponce.builder()
					.error("Customer not found")
					.errorCode(HttpStatus.NOT_FOUND)
					.build();
		}else if(ex.status()==503) {
			responce = ErrorResponce.builder()
					.error("Service unavailable")
					.errorCode(HttpStatus.SERVICE_UNAVAILABLE)
					.build();
		}else {
			responce = ErrorResponce.builder()
					.error("Internal Server Error")
					.errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
		
		return ResponseEntity.ok(responce);
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponce>handleRunTimeException(RuntimeException ex){
		ErrorResponce responce = ErrorResponce.builder()
		              .error("Internal Server Error")
		              .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
		              .build();
		              
		System.err.println("RuntimeException: " + ex.getMessage());
		ex.printStackTrace();

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responce);
	}
}
