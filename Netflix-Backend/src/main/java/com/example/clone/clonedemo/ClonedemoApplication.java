package com.example.clone.clonedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.clone.clonedemo.entity")

public class ClonedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClonedemoApplication.class, args);
	}

}
