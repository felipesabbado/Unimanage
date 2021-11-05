package com.iade.unimanage.models;

public class EnrolmentRepository {
    public static void populate() {
        StudentRepository.getStudent(1).enroll(new Enrolment(StudentRepository.getStudent(1), 
            UnitRepository.getUnit(1), 14.3));
        StudentRepository.getStudent(1).enroll(new Enrolment(StudentRepository.getStudent(1), 
            UnitRepository.getUnit(3), 12.1));
        StudentRepository.getStudent(1).enroll(new Enrolment(StudentRepository.getStudent(1), 
            UnitRepository.getUnit(5), 10.0));
        StudentRepository.getStudent(2).enroll(new Enrolment(StudentRepository.getStudent(1), 
            UnitRepository.getUnit(2), -1));
        StudentRepository.getStudent(2).enroll(new Enrolment(StudentRepository.getStudent(1), 
            UnitRepository.getUnit(4), -1));
    }
}
