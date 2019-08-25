package com.springboot.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJdbcApplication {
	
//adding comments
    @Autowired
    private static CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcApplication.class, args);
		 customerRepository.findAll();
				 
	}

}
