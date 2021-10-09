package com.iade.unimanage;

import com.iade.unimanage.models.StudentRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnimanageApplication {

	public static void main(String[] args) {
		StudentRepository.populate();
		SpringApplication.run(UnimanageApplication.class, args);
	}

}
