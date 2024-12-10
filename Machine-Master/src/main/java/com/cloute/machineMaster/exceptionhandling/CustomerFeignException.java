package com.cloute.machineMaster.exceptionhandling;

import feign.FeignException;

public class CustomerFeignException extends FeignException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerFeignException(int status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}
	
}
