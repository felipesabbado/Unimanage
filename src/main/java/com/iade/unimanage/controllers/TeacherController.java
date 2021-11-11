package com.iade.unimanage.controllers;

import java.util.List;

import com.iade.unimanage.models.Teacher;
import com.iade.unimanage.models.repositories.TeacherRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getTeachers() {
        logger.info("Getting " + TeacherRepository.getTeachers().size() + " teachers");
        return TeacherRepository.getTeachers();
    }
}
