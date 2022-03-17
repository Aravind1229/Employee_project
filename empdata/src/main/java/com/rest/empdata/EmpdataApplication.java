package com.rest.empdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="com.rest.empdata")
public class EmpdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpdataApplication.class, args);
	}

}
