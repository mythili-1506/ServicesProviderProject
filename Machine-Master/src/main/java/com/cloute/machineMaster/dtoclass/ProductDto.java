package com.cloute.machineMaster.dtoclass;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
	
	private long productId;
	
	private String productCode;
	
	private String ModelName;
	
	private String ProductName;
	
	private String productDesc;
	
	private int productStatus;
}
