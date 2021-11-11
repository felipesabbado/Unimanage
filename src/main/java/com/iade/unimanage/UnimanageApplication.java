package com.iade.unimanage;

import com.iade.unimanage.models.repositories.EnrolmentRepository;
import com.iade.unimanage.models.repositories.StudentRepository;
import com.iade.unimanage.models.repositories.TeacherRepository;
import com.iade.unimanage.models.repositories.UnitRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnimanageApplication {

	public static void main(String[] args) {
		StudentRepository.populate();
		UnitRepository.populate();
		EnrolmentRepository.populate();
		TeacherRepository.populate();
		SpringApplication.run(UnimanageApplication.class, args);
	}

}
