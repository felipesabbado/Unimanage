package com.iade.unimanage.controllers;

import java.util.List;

import com.iade.unimanage.models.Enrolment;
import com.iade.unimanage.models.Student;
import com.iade.unimanage.models.StudentRepository;
import com.iade.unimanage.models.Unit;
import com.iade.unimanage.models.UnitRepository;
import com.iade.unimanage.models.exceptions.AlredyExistsException;
import com.iade.unimanage.models.exceptions.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path = "{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("number") int number) throws NotFoundException{
        logger.info("Getting student #" + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) return student;
        else throw new NotFoundException("" + number, "Student", "number");
    }

    @DeleteMapping(path = "{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable("number") int number){
        logger.info("Deleting student #" + number);
        if (StudentRepository.deleteStudent(number)){
            return new Response(number + " was deleted.", null);
        } else {
            return new Response(number + " not found.", null);
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student){
        logger.info("Added student " + student.getName());
        StudentRepository.addStudent(student);
        return student;
    }

    @GetMapping(path = "{number}/enrolments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Enrolment> getEnrolments(@PathVariable("number") int number) throws NotFoundException{
        logger.info("Sending enrolments os student with number" + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) return student.getEnrolments();
        else throw new NotFoundException("" + number, "Student", "number");
    }

    @GetMapping(path = "{number}/enrolment/{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment getEnrolment(@PathVariable ("number") int number, @PathVariable ("unitId") int unitId) throws
    NotFoundException{
        logger.info("Sending enrolment with id" + unitId + " of student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Enrolment enr = student.getEnrolmentByUnitId(unitId);
            if (enr != null) return enr;
            else throw new NotFoundException("" + unitId, "Unit", "id");
        } else throw new NotFoundException("" + number, "Student", "number");
    }

    @PutMapping(path = "{number}/enrolments/{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment setGrade(@PathVariable("number") int number, @PathVariable("unitId") int unitId, 
                                @RequestBody double grade) throws NotFoundException {
    logger.info("Setting grade of enrolment with id " + unitId + " of student with number " + number);
    Student student = StudentRepository.getStudent(number);
    if (student != null) {
        Enrolment enr = student.getEnrolmentByUnitId(unitId);
        if (enr != null) {
            enr.setGrade(grade);
            return enr;
        } else throw new NotFoundException("" + unitId, "Unit", "id");
    } else throw new NotFoundException("" + number, "Student", "number");
    }

    @PostMapping(path = "{number}/enrolments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment addEnrolment(@PathVariable("number") int number, @RequestBody int unitId) 
                                    throws NotFoundException, AlredyExistsException {
        logger.info("Enroling student with number " + number + " in unit with id " + unitId);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Unit unit = UnitRepository.getUnit(unitId);
            if (unit != null) {
                if (student.getEnrolmentByUnitId(unitId) != null)
                    throw new AlredyExistsException("" + unitId, "Unit", "id");
                else {
                    Enrolment enrolment = new Enrolment(student, unit, -1);
                    student.enroll(enrolment);
                    return enrolment;
                }
            } else throw new NotFoundException("" + unitId, "Unit", "id");
        } else throw new NotFoundException("" + number, "Student", "number");
    }
}
