package com.cloute.machineMaster.exceptionhandling;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponce {
	
	public String error;
	private HttpStatus errorCode;
}
