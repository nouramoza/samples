package com.blu.bankservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BankserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankserviceApplication.class, args);
	}

}
