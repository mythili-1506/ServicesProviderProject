package com.cloute.customermaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CustomerMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMasterApplication.class, args);
	}

}
