package com.iade.unimanage.controllers;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.iade.unimanage.models.Student;
import com.iade.unimanage.models.StudentRepository;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/students")
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents(){
        logger.info("Getting " + StudentRepository.getStudents().size() + " students");
        return StudentRepository.getStudents();
    }

    @GetMapping(path = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("number") int number){
        logger.info("Getting student #" + number);
        return StudentRepository.getStudent(number);
    }

    /*@DeleteMapping(path = "/delete/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable("number") int number){
        logger.info("Deleting student #" + number);
        if (StudentRepository.deleteStudent(number)){
            return new Response(number + " was deleted.", null);
        } else {
            return new Response(number + " not found.", null);
        }
    }*/

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student){
        logger.info("Added student " + student.getName());
        StudentRepository.addStudent(student);
        return student;
    }
}
