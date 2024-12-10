package com.cloute.machineMaster.exceptionhandling;

import feign.FeignException;

public class ProductFeignException extends FeignException {
	
	private static final long serialVersionUID = 1L;

	public ProductFeignException(int status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}

}
