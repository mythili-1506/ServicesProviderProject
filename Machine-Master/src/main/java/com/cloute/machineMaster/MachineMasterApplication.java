package com.cloute.machineMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MachineMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachineMasterApplication.class, args);
	}

}
